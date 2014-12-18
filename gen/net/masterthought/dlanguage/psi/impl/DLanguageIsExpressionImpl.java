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

public class DLanguageIsExpressionImpl extends ASTWrapperPsiElement implements DLanguageIsExpression {

  public DLanguageIsExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DLanguageVisitor) ((DLanguageVisitor)visitor).visitIsExpression(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public DLanguageTemplateParameterList getTemplateParameterList() {
    return findChildByClass(DLanguageTemplateParameterList.class);
  }

  @Override
  @NotNull
  public DLanguageType getType() {
    return findNotNullChildByClass(DLanguageType.class);
  }

  @Override
  @Nullable
  public DLanguageTypeSpecialization getTypeSpecialization() {
    return findChildByClass(DLanguageTypeSpecialization.class);
  }

  @Override
  @NotNull
  public PsiElement getCloseParens() {
    return findNotNullChildByType(CLOSE_PARENS);
  }

  @Override
  @Nullable
  public PsiElement getColon() {
    return findChildByType(COLON);
  }

  @Override
  @Nullable
  public PsiElement getComma() {
    return findChildByType(COMMA);
  }

  @Override
  @Nullable
  public PsiElement getEquals() {
    return findChildByType(EQUALS);
  }

  @Override
  @Nullable
  public PsiElement getIdentifier() {
    return findChildByType(IDENTIFIER);
  }

  @Override
  @NotNull
  public PsiElement getKwIs() {
    return findNotNullChildByType(KW_IS);
  }

  @Override
  @NotNull
  public PsiElement getOpenParens() {
    return findNotNullChildByType(OPEN_PARENS);
  }

}
