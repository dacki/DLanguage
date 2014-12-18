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

public class DLanguageForStatementImpl extends ASTWrapperPsiElement implements DLanguageForStatement {

  public DLanguageForStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DLanguageVisitor) ((DLanguageVisitor)visitor).visitForStatement(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<DLanguageDeclarationOrStatement> getDeclarationOrStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, DLanguageDeclarationOrStatement.class);
  }

  @Override
  @NotNull
  public List<DLanguageExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, DLanguageExpression.class);
  }

  @Override
  @NotNull
  public PsiElement getCloseParens() {
    return findNotNullChildByType(CLOSE_PARENS);
  }

  @Override
  @NotNull
  public PsiElement getKwFor() {
    return findNotNullChildByType(KW_FOR);
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
