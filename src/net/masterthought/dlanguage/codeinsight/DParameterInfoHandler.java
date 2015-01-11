package net.masterthought.dlanguage.codeinsight;


import com.google.common.collect.Lists;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.lang.parameterInfo.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiUtil;
import net.masterthought.dlanguage.codeinsight.dcd.DCDCompletionClient;
import net.masterthought.dlanguage.codeinsight.dcd.DCDCompletionServer;
import net.masterthought.dlanguage.codeinsight.dcd.completions.Completion;
import net.masterthought.dlanguage.psi.interfaces.DCompositeElement;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DParameterInfoHandler implements ParameterInfoHandler<DParameterWrapper,Object> {

    private final DCDCompletionClient dcdCompletionClient = new DCDCompletionClient();

    @Override
    public boolean couldShowInLookup() {
        return true;
    }

    @Nullable
    @Override
    public Object[] getParametersForLookup(LookupElement lookupElement, ParameterInfoContext parameterInfoContext) {
        return new Object[0];
    }

    @Nullable
    @Override
    public Object[] getParametersForDocumentation(Object o, ParameterInfoContext parameterInfoContext) {
        return new Object[0];
    }

    @Nullable
    @Override
    public DParameterWrapper findElementForParameterInfo(CreateParameterInfoContext context) {
        List<Completion> completions = Lists.newArrayList();
        try {
            int position = context.getEditor().getCaretModel().getOffset();
            PsiFile file = context.getFile();
            completions = dcdCompletionClient.autoCompleteCallTips(position, file);
        } catch (DCDCompletionServer.DCDError dcdError) {
            dcdError.printStackTrace();
        }
       DParameterWrapper wrapper = new DParameterWrapperImpl(context.getFile().getNode());
       wrapper.setParameterList(completions);
       return wrapper;
    }

    @Override
    public void showParameterInfo(DParameterWrapper wrapper, CreateParameterInfoContext context) {
        int position = context.getEditor().getCaretModel().getOffset();
        context.showHint(wrapper, position, this);
    }

    @Nullable
    @Override
    public DParameterWrapper findElementForUpdatingParameterInfo(UpdateParameterInfoContext context) {
        return new DParameterWrapperImpl(context.getFile().getNode());
    }

    @Override
    public void updateParameterInfo(DParameterWrapper wrapper, UpdateParameterInfoContext context) {

    }

    @Nullable
    @Override
    public String getParameterCloseChars() {
        return null;
    }

    @Override
    public boolean tracksParameterIndex() {
        return false;
    }

    @Override
    public void updateUI(Object wrapper, ParameterInfoUIContext context) {
        System.out.println("oops");


        context.setUIComponentEnabled(true);

        List<String> list = Lists.newArrayList();
//        for(Completion completion : (DParameterWrapper) wrapper.getParameterList()){
//            list.add(completion.completionText());
//        }

        context.setupUIComponentPresentation(StringUtils.join(list,"\\n"), 0, 0, false, false, false,
                context.getDefaultParameterColor());
    }

//    private final DCDCompletionClient dcdCompletionClient = new DCDCompletionClient();
//
//    @Override
//    public boolean couldShowInLookup() {
//        return true;
//    }
//
//    @Nullable
//    @Override
//    public Object[] getParametersForLookup(LookupElement lookupElement, ParameterInfoContext parameterInfoContext) {
//        return new Object[0];
//    }
//
//    @Nullable
//    @Override
//    public Object[] getParametersForDocumentation(Object o, ParameterInfoContext parameterInfoContext) {
//        return new Object[0];
//    }
//
//    @Nullable
//    @Override
//    public Object findElementForParameterInfo(CreateParameterInfoContext context) {
//        int offset = context.getEditor().getCaretModel().getOffset();
//        PsiElement ele = PsiUtil.getElementAtOffset(context.getFile(), offset);
//        return ele;
//    }
//
//    @Override
//    public void showParameterInfo(Object o, CreateParameterInfoContext context) {
//        if (o instanceof PsiElement) {
//            int position = context.getEditor().getCaretModel().getOffset();
//            PsiFile file = context.getFile();
//
//            List<Completion> completions = Lists.newArrayList();
//            try {
//                completions = dcdCompletionClient.autoComplete(position, file);
//            } catch (DCDCompletionServer.DCDError dcdError) {
//                dcdError.printStackTrace();
//            }
//
//            context.showHint((PsiElement) o, position, this);
//        }
//    }
//
//    @Nullable
//    @Override
//    public Object findElementForUpdatingParameterInfo(UpdateParameterInfoContext context) {
//        int offset = context.getEditor().getCaretModel().getOffset();
//        PsiElement ele = PsiUtil.getElementAtOffset(context.getFile(), offset);
//        return ele;
//    }
//
//    @Override
//    public void updateParameterInfo(Object o, UpdateParameterInfoContext updateParameterInfoContext) {
//
//    }
//
//    @Nullable
//    @Override
//    public String getParameterCloseChars() {
//        return null;
//    }
//
//    @Override
//    public boolean tracksParameterIndex() {
//        return false;
//    }
//
//    @Override
//    public void updateUI(Object o, ParameterInfoUIContext context) {
//        System.out.println("oops");
//
//        context.setUIComponentEnabled(true);
//        context.setupUIComponentPresentation("wooooo hoooo", 0, 0, false, false, false,
//                context.getDefaultParameterColor());
//    }


}
