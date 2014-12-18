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

public class DLanguageTemplateSingleArgumentImpl extends ASTWrapperPsiElement implements DLanguageTemplateSingleArgument {

  public DLanguageTemplateSingleArgumentImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DLanguageVisitor) ((DLanguageVisitor)visitor).visitTemplateSingleArgument(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public DLanguageBuiltinType getBuiltinType() {
    return findChildByClass(DLanguageBuiltinType.class);
  }

  @Override
  @Nullable
  public PsiElement getCharacter() {
    return findChildByType(CHARACTER);
  }

  @Override
  @Nullable
  public PsiElement getGroupFloat() {
    return findChildByType(GROUP_FLOAT);
  }

  @Override
  @Nullable
  public PsiElement getGroupInteger() {
    return findChildByType(GROUP_INTEGER);
  }

  @Override
  @Nullable
  public PsiElement getGroupString() {
    return findChildByType(GROUP_STRING);
  }

  @Override
  @Nullable
  public PsiElement getIdentifier() {
    return findChildByType(IDENTIFIER);
  }

  @Override
  @Nullable
  public PsiElement getKwFalse() {
    return findChildByType(KW_FALSE);
  }

  @Override
  @Nullable
  public PsiElement getKwNull() {
    return findChildByType(KW_NULL);
  }

  @Override
  @Nullable
  public PsiElement getKwThis() {
    return findChildByType(KW_THIS);
  }

  @Override
  @Nullable
  public PsiElement getKwTrue() {
    return findChildByType(KW_TRUE);
  }

  @Override
  @Nullable
  public PsiElement getKwDate() {
    return findChildByType(KW___DATE__);
  }

  @Override
  @Nullable
  public PsiElement getKwFile() {
    return findChildByType(KW___FILE__);
  }

  @Override
  @Nullable
  public PsiElement getKwFunction() {
    return findChildByType(KW___FUNCTION__);
  }

  @Override
  @Nullable
  public PsiElement getKwLine() {
    return findChildByType(KW___LINE__);
  }

  @Override
  @Nullable
  public PsiElement getKwModule() {
    return findChildByType(KW___MODULE__);
  }

  @Override
  @Nullable
  public PsiElement getKwPrettyFunction() {
    return findChildByType(KW___PRETTY_FUNCTION__);
  }

  @Override
  @Nullable
  public PsiElement getKwTimestamp() {
    return findChildByType(KW___TIMESTAMP__);
  }

  @Override
  @Nullable
  public PsiElement getKwTime() {
    return findChildByType(KW___TIME__);
  }

  @Override
  @Nullable
  public PsiElement getKwVendor() {
    return findChildByType(KW___VENDOR__);
  }

  @Override
  @Nullable
  public PsiElement getKwVersion() {
    return findChildByType(KW___VERSION__);
  }

}
