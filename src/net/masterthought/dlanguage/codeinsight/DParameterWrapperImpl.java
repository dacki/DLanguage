package net.masterthought.dlanguage.codeinsight;

import com.google.common.collect.Lists;
import com.intellij.lang.ASTNode;
import net.masterthought.dlanguage.codeinsight.dcd.completions.Completion;
import net.masterthought.dlanguage.psi.impl.DCompositeElementImpl;

import java.util.List;

public class DParameterWrapperImpl extends DCompositeElementImpl implements DParameterWrapper{

    private List<Completion> completions = Lists.newArrayList();

    public DParameterWrapperImpl(ASTNode node) {
        super(node);
    }

    @Override
    public List<Completion> getParameterList() {
        return completions;
    }

    public void setParameterList(List<Completion> items){
      completions = items;
    }
}
