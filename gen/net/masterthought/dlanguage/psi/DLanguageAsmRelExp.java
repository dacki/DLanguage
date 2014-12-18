// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DLanguageAsmRelExp extends PsiElement {

  @NotNull
  List<DLanguageAsmShiftExp> getAsmShiftExpList();

  @Nullable
  PsiElement getGreaterEqual();

  @Nullable
  PsiElement getGreaterThan();

  @Nullable
  PsiElement getLessEqual();

  @Nullable
  PsiElement getLessThan();

}
