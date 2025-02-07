package io.github.warraft.vex.antlr.state

import io.github.warraft.VjassLexer
import io.github.warraft.VjassParser
import io.github.warraft.VjassParser.*
import io.github.warraft.jass.antlr.utils.JassErrorListener
import io.github.warraft.languages.lsp4j.service.document.semantic.token.SemanticTokenType
import io.github.warraft.languages.antlr.state.LanguageState
import io.github.warraft.languages.antlr.utils.LanguageTokenFactory
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CommonToken
import org.antlr.v4.runtime.CommonTokenStream

class VjassState : VexState() {

    override fun parse(stream: CharStream, states: List<LanguageState>) {
        super.parse(stream, states)
        val errorJassErrorListener = JassErrorListener()
        val lexer = VjassLexer(stream)
        lexer.removeErrorListeners()
        lexer.addErrorListener(errorJassErrorListener)
        val f = LanguageTokenFactory(mutableMapOf<Int, CommonToken>())
        lexer.tokenFactory = f

        val tokens = CommonTokenStream(lexer)

        val parser = VjassParser(tokens)
        parser.removeErrorListeners()
        parser.addErrorListener(errorJassErrorListener)
        root(parser.root())

        for (c in f.comments) {
            semanticHub.add(c, SemanticTokenType.COMMENT)
        }
    }

    fun root(ctx: RootContext) {
        for (item in ctx.children) {
            server?.log("vjass | ${item.javaClass.simpleName}")
            when (item) {
                is LibraryContext -> library(item)
                is RootItemContext -> rootItem(item)
            }
        }
    }

    fun library(ctx: LibraryContext) {
        semanticHub
            .add(ctx.LIBRARY(), SemanticTokenType.KEYWORD)
            .add(ctx.INITIALIZER(), SemanticTokenType.KEYWORD)
            .add(ctx.USES(), SemanticTokenType.KEYWORD)
            .add(ctx.ENDLIBRARY(), SemanticTokenType.KEYWORD)

        for (item in ctx.rootItem()) rootItem(item)
    }

    fun rootItem(ctx: RootItemContext) {
        for (item in ctx.children) {
            when (item) {
                is GlobalsContext -> globals(item)
                is FunctionContext -> function(item)
            }
        }
    }

    fun function(ctx: FunctionContext) {
        semanticHub
            .add(ctx.FUNCTION(), SemanticTokenType.KEYWORD)
            .add(ctx.ENDFUNCTION(), SemanticTokenType.KEYWORD)

        val takesCtx: TakesContext? = ctx.takes()
        semanticHub
            .add(takesCtx?.TAKES(), SemanticTokenType.KEYWORD)
            .add(takesCtx?.NOTHING(), SemanticTokenType.KEYWORD)

        val returnsCtx: ReturnsRuleContext? = ctx.returnsRule()
        semanticHub
            .add(returnsCtx?.RETURNS(), SemanticTokenType.KEYWORD)
            .add(returnsCtx?.NOTHING(), SemanticTokenType.KEYWORD)
    }

    fun globals(ctx: GlobalsContext) {
        semanticHub
            .add(ctx.GLOBALS(), SemanticTokenType.KEYWORD)
            .add(ctx.ENDGLOBALS(), SemanticTokenType.KEYWORD)
    }

}
