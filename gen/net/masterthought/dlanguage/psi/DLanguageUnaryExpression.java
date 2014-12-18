// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DLanguageUnaryExpression extends PsiElement {

  @Nullable
  DLanguageArgumentList getArgumentList();

  @Nullable
  DLanguageArguments getArguments();

  @Nullable
  DLanguageAssertExpression getAssertExpression();

  @NotNull
  List<DLanguageAssignExpression> getAssignExpressionList();

  @Nullable
  DLanguageCastExpression getCastExpression();

  @Nullable
  DLanguageDeleteExpression getDeleteExpression();

  @Nullable
  DLanguageIdentifierOrTemplateInstance getIdentifierOrTemplateInstance();

  @Nullable
  DLanguageNewExpression getNewExpression();

  @Nullable
  DLanguagePrimaryExpression getPrimaryExpression();

  @Nullable
  DLanguageTemplateArguments getTemplateArguments();

  @Nullable
  DLanguageType getType();

  @Nullable
  DLanguageUnaryExpression getUnaryExpression();

  @Nullable
  PsiElement getAnd();

  @Nullable
  PsiElement getCloseBracket();

  @Nullable
  PsiElement getCloseParens();

  @Nullable
  PsiElement getConcat();

  @Nullable
  PsiElement getDecrement();

  @Nullable
  PsiElement getDot();

  @Nullable
  PsiElement getDoubleDot();

  @Nullable
  PsiElement getIncrement();

  @Nullable
  PsiElement getMinus();

  @Nullable
  PsiElement getNot();

  @Nullable
  PsiElement getOpenBracket();

  @Nullable
  PsiElement getOpenParens();

  @Nullable
  PsiElement getPlus();

  @Nullable
  PsiElement getStar();

}
