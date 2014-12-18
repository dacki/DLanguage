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

public class DLanguageRelOperatorImpl extends ASTWrapperPsiElement implements DLanguageRelOperator {

  public DLanguageRelOperatorImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DLanguageVisitor) ((DLanguageVisitor)visitor).visitRelOperator(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getGreaterEqual() {
    return findChildByType(GREATER_EQUAL);
  }

  @Override
  @Nullable
  public PsiElement getGreaterThan() {
    return findChildByType(GREATER_THAN);
  }

  @Override
  @Nullable
  public PsiElement getLessEqual() {
    return findChildByType(LESS_EQUAL);
  }

  @Override
  @Nullable
  public PsiElement getLessGreater() {
    return findChildByType(LESS_GREATER);
  }

  @Override
  @Nullable
  public PsiElement getLessGreaterEqual() {
    return findChildByType(LESS_GREATER_EQUAL);
  }

  @Override
  @Nullable
  public PsiElement getLessThan() {
    return findChildByType(LESS_THAN);
  }

  @Override
  @Nullable
  public PsiElement getUnordered() {
    return findChildByType(UNORDERED);
  }

  @Override
  @Nullable
  public PsiElement getUnorderedE() {
    return findChildByType(UNORDERED_E);
  }

  @Override
  @Nullable
  public PsiElement getUnorderedG() {
    return findChildByType(UNORDERED_G);
  }

  @Override
  @Nullable
  public PsiElement getUnorderedGe() {
    return findChildByType(UNORDERED_GE);
  }

  @Override
  @Nullable
  public PsiElement getUnorderedL() {
    return findChildByType(UNORDERED_L);
  }

  @Override
  @Nullable
  public PsiElement getUnorderedLe() {
    return findChildByType(UNORDERED_LE);
  }

}
