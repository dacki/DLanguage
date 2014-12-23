package net.masterthought.dlanguage.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiReference;
import net.masterthought.dlanguage.psi.interfaces.DDefinitionFunction;
import org.jetbrains.annotations.NotNull;

public class DDefinitionFunctionImpl extends DCompositeElementImpl implements DDefinitionFunction{

    public DDefinitionFunctionImpl(ASTNode node) {
        super(node);
    }


    @NotNull
    public PsiReference getReference() {
        return DPsiImplUtil.getReference(this);
    }

}
