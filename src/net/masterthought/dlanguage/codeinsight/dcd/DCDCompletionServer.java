package net.masterthought.dlanguage.codeinsight.dcd;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.configurations.ParametersList;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleComponent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.roots.libraries.Library;
import com.intellij.openapi.roots.libraries.LibraryTable;
import com.intellij.openapi.roots.libraries.LibraryTablesRegistrar;
import com.intellij.openapi.util.SystemInfo;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.containers.ContainerUtil;
import net.masterthought.dlanguage.DLanguageSdkType;
import net.masterthought.dlanguage.project.DubConfigurationParser;
import net.masterthought.dlanguage.settings.SettingsChangeNotifier;
import net.masterthought.dlanguage.settings.ToolKey;
import net.masterthought.dlanguage.settings.ToolSettings;
import net.masterthought.dlanguage.utils.ExecUtil;
import net.masterthought.dlanguage.utils.NotificationUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static net.masterthought.dlanguage.utils.DUtil.isNotNullOrEmpty;

/**
 * Process wrapper for DCD Server.  Implements ModuleComponent so destruction of processes coincides with closing projects.
 */
public class DCDCompletionServer implements ModuleComponent, SettingsChangeNotifier {

    public
    @NotNull
    final Module module;
    public
    @NotNull
    String workingDirectory;
    public
    @Nullable
    String path;
    public
    @NotNull
    String flags;
    private
    @Nullable
    Process process;
    private
    @Nullable
    BufferedReader input;
    private
    @Nullable
    BufferedWriter output;
    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Nullable
    public synchronized void exec() throws DCDError {
        if (path != null) {
            if (process == null) {
                spawnProcess();
            }
            if (output == null) {
                throw new InitError("Output stream was unexpectedly null.");
            }
            if (input == null) {
                throw new InitError("Input stream was unexpectedly null.");
            }
        }
    }

    private void spawnProcess() throws DCDError {
        GeneralCommandLine commandLine = new GeneralCommandLine(path);
        commandLine.setWorkDirectory(workingDirectory);
        commandLine.setRedirectErrorStream(true);
        ParametersList parametersList = commandLine.getParametersList();


        if (isNotNullOrEmpty(flags)) {
            List<String> importList = Arrays.asList(flags.split(","));
            for (String item : importList) {
                parametersList.addParametersString("-I");
                parametersList.addParametersString(item);
            }
        }

        // try to auto add project files in source root
        String sources = getRootSourceDir();
        if (isNotNullOrEmpty(sources)) {
            parametersList.addParametersString("-I");
            parametersList.addParametersString(sources);
        }

        // try to auto add the compiler sources
        List<String> compilerSources = getCompilerSourceDirs();
        for (String s : compilerSources) {
            parametersList.addParametersString("-I");
            parametersList.addParametersString(s);
        }

        // try to auto add dub dependecies
        DubConfigurationParser dubConfig = new DubConfigurationParser(module.getProject(), ToolKey.DUB_KEY.getPath(module.getProject()));
        for(DubConfigurationParser.DubPackage pkg : dubConfig.getDubPackageDependencies()){
            parametersList.addParametersString("-I");
            parametersList.addParametersString(pkg.path + pkg.sourcesDir);
        }

        try {
            process = commandLine.createProcess();
        } catch (ExecutionException e) {
            throw new InitError(e.toString());
        }
        input = new BufferedReader(new InputStreamReader(process.getInputStream()));
        output = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));

    }

    private String getRootSourceDir() {
        Project myProject = module.getProject();
        final List<VirtualFile> sourceRoots = new ArrayList<>();
        final ProjectRootManager projectRootManager = ProjectRootManager.getInstance(myProject);
        ContainerUtil.addAll(sourceRoots, projectRootManager.getContentSourceRoots());
        return sourceRoots.isEmpty() ? null : sourceRoots.get(0).getPath();
    }

    private List<String> getCompilerSourceDirs() {
        ArrayList<String> compilerSources = new ArrayList<>();
        ModuleRootManager moduleRootManager = ModuleRootManager.getInstance(module);
        Sdk sdk = moduleRootManager.getSdk();

        if (sdk != null && (sdk.getSdkType() instanceof DLanguageSdkType)) {
            String path = sdk.getHomePath();
            if (isNotNullOrEmpty(path)) {
                if (SystemInfo.isMac) {
                    String root = path.replaceAll("bin", "src");
                    compilerSources.add(root + "/phobos");
                    compilerSources.add(root + "/druntime/import");
                } else if (SystemInfo.isLinux) {
                    compilerSources.add("/usr/include/dlang/dmd");
                }
                // add linux and windows here once I know how
            }
        }
        return compilerSources;
    }

    @NotNull
    private String lookupWorkingDirectory() {
        return ExecUtil.guessWorkDir(module);
    }

    /**
     * Private constructor used during module component initialization.
     */
    public DCDCompletionServer(@NotNull Module module) {
        this.module = module;
        this.path = lookupPath();
        this.flags = lookupFlags();
        this.workingDirectory = lookupWorkingDirectory();
        // Ensure that we are notified of changes to the settings.
        module.getProject().getMessageBus().connect().subscribe(SettingsChangeNotifier.DCD_TOPIC, this);
    }

    @Nullable
    private String lookupPath() {
        return ToolKey.DCD_SERVER_KEY.getPath(module.getProject());
    }

    @NotNull
    private String lookupFlags() {
        return ToolKey.DCD_SERVER_KEY.getFlags(module.getProject());
    }


    // Custom Exceptions
    public static abstract class DCDError extends Exception {
        // Using error to index errors since message might have extra information.
        final
        @NotNull
        String error;
        final
        @NotNull
        String message;
        final boolean killProcess;

        DCDError(@NotNull String error, @NotNull String message, boolean killProcess) {
            this.error = error;
            this.message = message;
            this.killProcess = killProcess;
        }
    }

    public static class InitError extends DCDError {
        InitError(@NotNull String error) {
            super(error, "Initializing dcd server failed with error: " + error, true);
        }
    }

    /**
     * Kills the existing process and closes input and output if they exist.
     */
    private synchronized void kill() {
        if (process != null) process.destroy();
        process = null;
        try {
            if (input != null) input.close();
        } catch (IOException e) { /* Ignored */ }
        input = null;
        try {
            if (output != null) output.close();
        } catch (IOException e) { /* Ignored */ }
        output = null;
    }


    // Implemented methods for SettingsChangeNotifieer
    @Override
    public void onSettingsChanged(@NotNull ToolSettings settings) {
        this.path = settings.getPath();
        this.flags = settings.getFlags();
        restart();
    }

    /**
     * Restarts the dcd-server.
     */
    public synchronized void restart() {
        kill();
        try {
            Thread.sleep(1500);
            spawnProcess();
        } catch (DCDError e) {
            displayError(e.message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void displayError(@NotNull String message) {
        displayError(module.getProject(), message);
    }

    private static void displayError(@NotNull Project project, @NotNull String message) {
        NotificationUtil.displayToolsNotification(NotificationType.ERROR, project, "dcd error", message);
    }

    // Implemented methods for ModuleComponent.

    @Override
    public void projectOpened() {
        // No need to do anything here.
    }

    @Override
    public void projectClosed() {
// No need to do anything here.
    }

    @Override
    public void moduleAdded() {
// No need to do anything here.
    }

    @Override
    public void initComponent() {
// No need to do anything here.
    }

    @Override
    public void disposeComponent() {
        executorService.shutdownNow();
        kill();
    }

    @NotNull
    @Override
    public String getComponentName() {
        return "DCDCompletionServer";
    }
}
