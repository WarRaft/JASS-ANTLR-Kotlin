package io.github.warraft.language.wts.state

import io.github.warraft.WtsLexer
import io.github.warraft.WtsParser
import io.github.warraft.WtsParser.ItemContext
import io.github.warraft.language._.state.LanguageState
import io.github.warraft.lsp.data.semantic.SemanticTokenType
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.Lexer
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.tree.TerminalNode

class WtsState : LanguageState() {
    override fun lexer(stream: CharStream): Lexer = WtsLexer(stream)
    override fun parser(stream: CommonTokenStream): Parser = WtsParser(stream)

    fun item(ctx: ItemContext) {
        val stringCtx: TerminalNode? = ctx.STRING()
        val numberCtx: TerminalNode? = ctx.NUMBER()
        val blockCtx: TerminalNode? = ctx.BLOCK()

        semanticHub
            .add(stringCtx, SemanticTokenType.KEYWORD)
            .add(numberCtx, SemanticTokenType.NUMBER)

        if (numberCtx == null) return
        val blockText = blockCtx?.text ?: return

        val s = blockCtx.symbol

        //val sl = blockCtx.symbol.line
        for ((i, lineItem) in blockText.lines().withIndex()) {
            val l = s.line + i
            var pos = 0
            if (l == s.line) pos = s.charPositionInLine
            val len = lineItem.length

            semanticHub.add(
                line = l - 1,
                pos = pos,
                len = len,
                type = SemanticTokenType.STRING,
            )
            //server?.log("$lines")
        }
    }

    override fun parse(stream: CharStream, states: List<LanguageState>, version: Int?) {
        if (!needParse(version)) return

        super.parse(stream, states, version)

        rootCtx = (parser as WtsParser).root().also {
            it.children.forEach {
                when (it) {
                    is ItemContext -> item(it)
                }
            }
        }

        for (c in tokenFactory.commentList) {
            semanticHub.add(c, SemanticTokenType.COMMENT)
        }
    }
}
