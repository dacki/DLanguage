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

public class DLanguageForeachStatementImpl extends ASTWrapperPsiElement implements DLanguageForeachStatement {

  public DLanguageForeachStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DLanguageVisitor) ((DLanguageVisitor)visitor).visitForeachStatement(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public DLanguageDeclarationOrStatement getDeclarationOrStatement() {
    return findNotNullChildByClass(DLanguageDeclarationOrStatement.class);
  }

  @Override
  @NotNull
  public List<DLanguageExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, DLanguageExpression.class);
  }

  @Override
  @Nullable
  public DLanguageForeachType getForeachType() {
    return findChildByClass(DLanguageForeachType.class);
  }

  @Override
  @Nullable
  public DLanguageForeachTypeList getForeachTypeList() {
    return findChildByClass(DLanguageForeachTypeList.class);
  }

  @Override
  @NotNull
  public PsiElement getCloseParens() {
    return findNotNullChildByType(CLOSE_PARENS);
  }

  @Override
  @Nullable
  public PsiElement getDoubleDot() {
    return findChildByType(DOUBLE_DOT);
  }

  @Override
  @Nullable
  public PsiElement getKwForeach() {
    return findChildByType(KW_FOREACH);
  }

  @Override
  @Nullable
  public PsiElement getKwForeachReverse() {
    return findChildByType(KW_FOREACH_REVERSE);
  }

  @Override
  @NotNull
  public PsiElement getOpenParens() {
    return findNotNullChildByType(OPEN_PARENS);
  }

  @Override
  @NotNull
  public PsiElement getSemicolon() {
    return findNotNullChildByType(SEMICOLON);
  }

}
