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

public class DLanguageAssignOperatorImpl extends ASTWrapperPsiElement implements DLanguageAssignOperator {

  public DLanguageAssignOperatorImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DLanguageVisitor) ((DLanguageVisitor)visitor).visitAssignOperator(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getAndAssign() {
    return findChildByType(AND_ASSIGN);
  }

  @Override
  @Nullable
  public PsiElement getAssign() {
    return findChildByType(ASSIGN);
  }

  @Override
  @Nullable
  public PsiElement getConcatAssign() {
    return findChildByType(CONCAT_ASSIGN);
  }

  @Override
  @Nullable
  public PsiElement getDivAssign() {
    return findChildByType(DIV_ASSIGN);
  }

  @Override
  @Nullable
  public PsiElement getLeftShiftAssign() {
    return findChildByType(LEFT_SHIFT_ASSIGN);
  }

  @Override
  @Nullable
  public PsiElement getMinusAssign() {
    return findChildByType(MINUS_ASSIGN);
  }

  @Override
  @Nullable
  public PsiElement getModAssign() {
    return findChildByType(MOD_ASSIGN);
  }

  @Override
  @Nullable
  public PsiElement getMultAssign() {
    return findChildByType(MULT_ASSIGN);
  }

  @Override
  @Nullable
  public PsiElement getOrAssign() {
    return findChildByType(OR_ASSIGN);
  }

  @Override
  @Nullable
  public PsiElement getPlusAssign() {
    return findChildByType(PLUS_ASSIGN);
  }

  @Override
  @Nullable
  public PsiElement getPowAssign() {
    return findChildByType(POW_ASSIGN);
  }

  @Override
  @Nullable
  public PsiElement getRightShiftAssign() {
    return findChildByType(RIGHT_SHIFT_ASSIGN);
  }

  @Override
  @Nullable
  public PsiElement getTripleRshiftAssign() {
    return findChildByType(TRIPLE_RSHIFT_ASSIGN);
  }

  @Override
  @Nullable
  public PsiElement getXorAssign() {
    return findChildByType(XOR_ASSIGN);
  }

}
