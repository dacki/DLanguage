// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DLanguagePrimaryExpression extends PsiElement {

  @Nullable
  DLanguageArrayLiteral getArrayLiteral();

  @Nullable
  DLanguageAssocArrayLiteral getAssocArrayLiteral();

  @Nullable
  DLanguageBuiltinType getBuiltinType();

  @Nullable
  DLanguageExpression getExpression();

  @Nullable
  DLanguageFunctionLiteralExpression getFunctionLiteralExpression();

  @Nullable
  DLanguageIdentifierOrTemplateInstance getIdentifierOrTemplateInstance();

  @Nullable
  DLanguageImportExpression getImportExpression();

  @Nullable
  DLanguageIsExpression getIsExpression();

  @Nullable
  DLanguageLambdaExpression getLambdaExpression();

  @Nullable
  DLanguageMixinExpression getMixinExpression();

  @Nullable
  DLanguageTraitsExpression getTraitsExpression();

  @Nullable
  DLanguageTypeidExpression getTypeidExpression();

  @Nullable
  DLanguageTypeofExpression getTypeofExpression();

  @Nullable
  DLanguageVector getVector();

  @Nullable
  PsiElement getCharacter();

  @Nullable
  PsiElement getCloseParens();

  @Nullable
  PsiElement getDollar();

  @Nullable
  PsiElement getDot();

  @Nullable
  PsiElement getGroupFloat();

  @Nullable
  PsiElement getGroupInteger();

  @Nullable
  PsiElement getIdentifier();

  @Nullable
  PsiElement getKwFalse();

  @Nullable
  PsiElement getKwNull();

  @Nullable
  PsiElement getKwSuper();

  @Nullable
  PsiElement getKwThis();

  @Nullable
  PsiElement getKwTrue();

  @Nullable
  PsiElement getKwDate();

  @Nullable
  PsiElement getKwFile();

  @Nullable
  PsiElement getKwFunction();

  @Nullable
  PsiElement getKwLine();

  @Nullable
  PsiElement getKwModule();

  @Nullable
  PsiElement getKwPrettyFunction();

  @Nullable
  PsiElement getKwTimestamp();

  @Nullable
  PsiElement getKwTime();

  @Nullable
  PsiElement getKwVendor();

  @Nullable
  PsiElement getKwVersion();

  @Nullable
  PsiElement getOpenParens();

}
