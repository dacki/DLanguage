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

public class DLanguageAsmOrExpImpl extends ASTWrapperPsiElement implements DLanguageAsmOrExp {

  public DLanguageAsmOrExpImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DLanguageVisitor) ((DLanguageVisitor)visitor).visitAsmOrExp(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public DLanguageAsmOrExp getAsmOrExp() {
    return findChildByClass(DLanguageAsmOrExp.class);
  }

  @Override
  @NotNull
  public DLanguageAsmXorExp getAsmXorExp() {
    return findNotNullChildByClass(DLanguageAsmXorExp.class);
  }

  @Override
  @Nullable
  public PsiElement getOpOr() {
    return findChildByType(OP_OR);
  }

}
