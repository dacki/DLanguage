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

public class DLanguageVersionConditionImpl extends ASTWrapperPsiElement implements DLanguageVersionCondition {

  public DLanguageVersionConditionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DLanguageVisitor) ((DLanguageVisitor)visitor).visitVersionCondition(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getCloseParens() {
    return findNotNullChildByType(CLOSE_PARENS);
  }

  @Override
  @Nullable
  public PsiElement getGroupInteger() {
    return findChildByType(GROUP_INTEGER);
  }

  @Override
  @Nullable
  public PsiElement getIdentifier() {
    return findChildByType(IDENTIFIER);
  }

  @Override
  @Nullable
  public PsiElement getKwAssert() {
    return findChildByType(KW_ASSERT);
  }

  @Override
  @Nullable
  public PsiElement getKwUnittest() {
    return findChildByType(KW_UNITTEST);
  }

  @Override
  @NotNull
  public PsiElement getKwVersion() {
    return findNotNullChildByType(KW_VERSION);
  }

  @Override
  @NotNull
  public PsiElement getOpenParens() {
    return findNotNullChildByType(OPEN_PARENS);
  }

}
