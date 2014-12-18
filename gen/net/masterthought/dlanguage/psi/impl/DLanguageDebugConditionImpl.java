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

public class DLanguageDebugConditionImpl extends ASTWrapperPsiElement implements DLanguageDebugCondition {

  public DLanguageDebugConditionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DLanguageVisitor) ((DLanguageVisitor)visitor).visitDebugCondition(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getCloseParens() {
    return findChildByType(CLOSE_PARENS);
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
  @NotNull
  public PsiElement getKwDebug() {
    return findNotNullChildByType(KW_DEBUG);
  }

  @Override
  @Nullable
  public PsiElement getOpenParens() {
    return findChildByType(OPEN_PARENS);
  }

}
