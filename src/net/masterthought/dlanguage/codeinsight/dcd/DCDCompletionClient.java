package net.masterthought.dlanguage.codeinsight.dcd;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.configurations.ParametersList;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtilCore;
import com.intellij.psi.PsiFile;
import net.masterthought.dlanguage.codeinsight.dcd.completions.CallTipCompletion;
import net.masterthought.dlanguage.codeinsight.dcd.completions.Completion;
import net.masterthought.dlanguage.codeinsight.dcd.completions.TextCompletion;
import net.masterthought.dlanguage.settings.ToolKey;
import net.masterthought.dlanguage.utils.ExecUtil;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DCDCompletionClient {

    private Map<String, String> completionTypeMap = getCompletionTypeMap();

    public List<Completion> autoComplete(int position, PsiFile file) throws DCDCompletionServer.DCDError {
        System.out.printf("from auto complete");
        final List<Completion> completions = Lists.newArrayList();
        final Module module = ModuleUtilCore.findModuleForPsiElement(file);
        if (module != null) {
            String path = lookupPath(module);
            String flags = lookupFlags(module);
            if (path != null) {
                DCDCompletionServer dcdCompletionServer = module.getComponent(DCDCompletionServer.class);
                dcdCompletionServer.exec();
                System.out.println("position: " + String.valueOf(position));
                final String filePath = file.getOriginalFile().getVirtualFile().getCanonicalPath();
                System.out.println(filePath);
                final String workingDirectory = file.getProject().getBasePath();

                final GeneralCommandLine commandLine = new GeneralCommandLine();
                commandLine.setWorkDirectory(workingDirectory);
                commandLine.setExePath(path);
                ParametersList parametersList = commandLine.getParametersList();
                parametersList.addParametersString(flags);
                parametersList.addParametersString("-c");
                parametersList.addParametersString(String.valueOf(position));
                parametersList.addParametersString(filePath);

                String result = ExecUtil.readCommandLine(commandLine, file.getText());

                if (result != null && !result.isEmpty()) {
                    List<String> tokens = Arrays.asList(result.split("\\n"));
                    String firstLine = tokens.get(0);
                    createCallTips(completions, tokens, firstLine);
                }
            }
        }
        return completions;
    }

    private void createCallTips(List<Completion> completions, List<String> tokens, String firstLine) {
        if (firstLine.contains("identifiers")) {
            for (String token : tokens) {
                if (!token.contains("identifiers")) {
                    List<String> parts = Arrays.asList(token.split("\\s"));
                    String completionType = getCompletionType(parts);
                    String completionText = getCompletionText(parts);
                    Completion completion = new TextCompletion(completionType, completionText);
                    completions.add(completion);
                    System.out.println(completion);
                }
            }
        }
    }

    public List<Completion> autoCompleteCallTips(int position, PsiFile file) throws DCDCompletionServer.DCDError {
        System.out.println("from calltips");
        final List<Completion> completions = Lists.newArrayList();
        final Module module = ModuleUtilCore.findModuleForPsiElement(file);
        if (module != null) {
            String path = lookupPath(module);
            String flags = lookupFlags(module);
            if (path != null) {
                DCDCompletionServer dcdCompletionServer = module.getComponent(DCDCompletionServer.class);
                dcdCompletionServer.exec();
                System.out.println("position: " + String.valueOf(position));
                final String filePath = file.getOriginalFile().getVirtualFile().getCanonicalPath();
                System.out.println(filePath);
                final String workingDirectory = file.getProject().getBasePath();

                final GeneralCommandLine commandLine = new GeneralCommandLine();
                commandLine.setWorkDirectory(workingDirectory);
                commandLine.setExePath(path);
                ParametersList parametersList = commandLine.getParametersList();
                parametersList.addParametersString(flags);
                parametersList.addParametersString("-c");
                parametersList.addParametersString(String.valueOf(position));
                parametersList.addParametersString(filePath);

                String result = ExecUtil.readCommandLine(commandLine, file.getText());

                if (result != null && !result.isEmpty()) {
                    List<String> tokens = Arrays.asList(result.split("\\n"));
                    String firstLine = tokens.get(0);
                    createIdentifiers(completions, tokens, firstLine);
                }
            }
        }
        return completions;
    }

    private void createIdentifiers(List<Completion> completions, List<String> tokens, String firstLine) {
        if (firstLine.contains("calltips")) {
            for (String token : tokens) {
                if (!token.contains("calltips")) {
                    List<String> parts = Arrays.asList(token.split("\\s"));
                    String completionType = getCompletionType(parts);
                    String completionText = getCompletionText(parts);
                    Completion completion = new CallTipCompletion(completionType, completionText);
                    completions.add(completion);
                    System.out.println(completion);
                }
            }
        }
    }

    @Nullable
    private String lookupPath(Module module) {
        return ToolKey.DCD_CLIENT_KEY.getPath(module.getProject());
    }

    @Nullable
    private String lookupFlags(Module module) {
        return ToolKey.DCD_CLIENT_KEY.getFlags(module.getProject());
    }

    private String getType(List<String> parts) {
        String type = parts.get(parts.size() - 1);
        return type.isEmpty() ? "U" : type.trim();
    }

    private String getCompletionType(List<String> parts) {
        String mapping = completionTypeMap.get(getType(parts));
        return mapping == null ? "Unknown" : mapping;
    }

    private String getCompletionText(List<String> parts) {
        String text = parts.get(0);
        String result = text.isEmpty() ? "" : text.trim();
        String type = getType(parts);
        if (type.equals("f")) {
            return result + "()";
        }
        return result;
    }

    private Map<String, String> getCompletionTypeMap() {
        Map<String, String> map = Maps.newTreeMap();
        map.put("c", "Class");
        map.put("i", "Interface");
        map.put("s", "Struct");
        map.put("u", "Union");
        map.put("v", "Variable");
        map.put("m", "Variable");
        map.put("k", "Keyword");
        map.put("f", "Function");
        map.put("g", "Enum");
        map.put("e", "Enum");
        map.put("P", "Package");
        map.put("M", "Module");
        map.put("a", "Array");
        map.put("A", "Map");
        map.put("l", "Alias");
        map.put("t", "Template");
        map.put("T", "Mixin");
        map.put("U", "Unknown");
        return map;
    }

}
