// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DLanguageLinkageAttribute extends PsiElement {

  @Nullable
  DLanguageIdentifierChain getIdentifierChain();

  @NotNull
  PsiElement getCloseParens();

  @Nullable
  PsiElement getComma();

  @NotNull
  PsiElement getIdentifier();

  @Nullable
  PsiElement getIncrement();

  @NotNull
  PsiElement getKwExtern();

  @NotNull
  PsiElement getOpenParens();

}
