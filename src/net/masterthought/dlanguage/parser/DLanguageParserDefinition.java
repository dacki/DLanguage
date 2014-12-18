package net.masterthought.dlanguage.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import net.masterthought.dlanguage.DLanguage;
import net.masterthought.dlanguage.lexer.DLexer;
import net.masterthought.dlanguage.psi.DLanguageFile;
import net.masterthought.dlanguage.psi.DLanguageTypes;
import org.jetbrains.annotations.NotNull;

public class DLanguageParserDefinition implements ParserDefinition {

    public static final IFileElementType FILE_ELEMENT_TYPE = new IFileElementType(DLanguage.INSTANCE);

    @NotNull
    @Override
    public Lexer createLexer(final Project project) {
        return new DLexer();
    }

    @Override
    public PsiParser createParser(final Project project) {
        return new DLanguageParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE_ELEMENT_TYPE;
    }

    @NotNull
    @Override
    public TokenSet getWhitespaceTokens() {
        return TokenSet.create(DLanguageTypes.WHITESPACE);
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return TokenSet.create(DLanguageTypes.GROUP_COMMENT);
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return TokenSet.create(DLanguageTypes.GROUP_STRING);
    }

    @NotNull
    @Override
    public PsiElement createElement(final ASTNode node) {
//        PsiElement ret = ElementTypes.Factory.createElement(node);
//        return ret;
        return DLanguageTypes.Factory.createElement(node);
    }

    @Override
    public PsiFile createFile(final FileViewProvider viewProvider) {
        return new DLanguageFile(viewProvider);
    }

    @Override
    public SpaceRequirements spaceExistanceTypeBetweenTokens(final ASTNode left, final ASTNode right) {
        // TODO: actually check input, return appropriate spacing requirements for same
        return SpaceRequirements.MAY;
    }
}
