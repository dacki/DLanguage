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

public class DLanguageWithStatementImpl extends ASTWrapperPsiElement implements DLanguageWithStatement {

  public DLanguageWithStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DLanguageVisitor) ((DLanguageVisitor)visitor).visitWithStatement(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public DLanguageExpression getExpression() {
    return findNotNullChildByClass(DLanguageExpression.class);
  }

  @Override
  @NotNull
  public DLanguageStatementNoCaseNoDefault getStatementNoCaseNoDefault() {
    return findNotNullChildByClass(DLanguageStatementNoCaseNoDefault.class);
  }

  @Override
  @NotNull
  public PsiElement getCloseParens() {
    return findNotNullChildByType(CLOSE_PARENS);
  }

  @Override
  @NotNull
  public PsiElement getKwWith() {
    return findNotNullChildByType(KW_WITH);
  }

  @Override
  @NotNull
  public PsiElement getOpenParens() {
    return findNotNullChildByType(OPEN_PARENS);
  }

}
