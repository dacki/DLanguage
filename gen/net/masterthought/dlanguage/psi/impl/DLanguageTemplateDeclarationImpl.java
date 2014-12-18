// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static net.masterthought.dlanguage.psi.DLanguageTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import net.masterthought.dlanguage.psi.*;

public class DLanguageTemplateDeclarationImpl extends ASTWrapperPsiElement implements DLanguageTemplateDeclaration {

  public DLanguageTemplateDeclarationImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DLanguageVisitor) ((DLanguageVisitor)visitor).visitTemplateDeclaration(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public DLanguageConstraint getConstraint() {
    return findChildByClass(DLanguageConstraint.class);
  }

  @Override
  @NotNull
  public List<DLanguageDeclaration> getDeclarationList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, DLanguageDeclaration.class);
  }

  @Override
  @Nullable
  public DLanguageEponymousTemplateDeclaration getEponymousTemplateDeclaration() {
    return findChildByClass(DLanguageEponymousTemplateDeclaration.class);
  }

  @Override
  @Nullable
  public DLanguageTemplateParameters getTemplateParameters() {
    return findChildByClass(DLanguageTemplateParameters.class);
  }

  @Override
  @Nullable
  public PsiElement getCloseBrace() {
    return findChildByType(CLOSE_BRACE);
  }

  @Override
  @Nullable
  public PsiElement getIdentifier() {
    return findChildByType(IDENTIFIER);
  }

  @Override
  @Nullable
  public PsiElement getKwTemplate() {
    return findChildByType(KW_TEMPLATE);
  }

  @Override
  @Nullable
  public PsiElement getOpenBrace() {
    return findChildByType(OPEN_BRACE);
  }

}
