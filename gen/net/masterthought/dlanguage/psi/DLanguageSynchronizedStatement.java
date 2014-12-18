// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DLanguageSynchronizedStatement extends PsiElement {

  @Nullable
  DLanguageExpression getExpression();

  @NotNull
  DLanguageStatementNoCaseNoDefault getStatementNoCaseNoDefault();

  @Nullable
  PsiElement getCloseParens();

  @NotNull
  PsiElement getKwSynchronized();

  @Nullable
  PsiElement getOpenParens();

}
