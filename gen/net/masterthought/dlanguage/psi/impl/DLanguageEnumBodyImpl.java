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

public class DLanguageEnumBodyImpl extends ASTWrapperPsiElement implements DLanguageEnumBody {

  public DLanguageEnumBodyImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DLanguageVisitor) ((DLanguageVisitor)visitor).visitEnumBody(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<DLanguageEnumMember> getEnumMemberList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, DLanguageEnumMember.class);
  }

  @Override
  @Nullable
  public PsiElement getCloseBrace() {
    return findChildByType(CLOSE_BRACE);
  }

  @Override
  @Nullable
  public PsiElement getOpenBrace() {
    return findChildByType(OPEN_BRACE);
  }

  @Override
  @Nullable
  public PsiElement getSemicolon() {
    return findChildByType(SEMICOLON);
  }

}
