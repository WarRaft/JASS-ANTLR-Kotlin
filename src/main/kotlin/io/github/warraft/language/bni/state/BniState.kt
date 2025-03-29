package io.github.warraft.language.bni.state

import io.github.warraft.BniLexer
import io.github.warraft.BniParser
import io.github.warraft.language._.state.LanguageState
import io.github.warraft.language.bni.state.Token.TokenType
import io.github.warraft.lsp.data.DocumentSymbol
import io.github.warraft.lsp.data.Range
import io.github.warraft.lsp.data.SymbolKind
import io.github.warraft.lsp.data.semantic.SemanticTokenType.*
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.Lexer
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.TerminalNode

class BniState : LanguageState() {
    override fun lexer(stream: CharStream): Lexer = BniLexer(stream)
    override fun parser(stream: CommonTokenStream): Parser = BniParser(stream)

    fun value(ctx: TerminalNode?) {
        if (ctx == null) return
        val s = ctx.symbol
        val input = ctx.text
        val line = ctx.symbol.line - 1
        var pos = s.charPositionInLine

        if (!input.startsWith("=")) return

        semanticHub.add(line = line, pos = pos, len = 1, type = OPERATOR)

        val tokens = Token.parse(input)
        for (t in tokens) {
            val tp = when (t.type) {
                TokenType.STRING,
                TokenType.TEXT,
                    -> STRING

                TokenType.NUMBER -> NUMBER
                TokenType.COMMENT -> COMMENT
                else -> null
            }

            if (tp != null) semanticHub.add(line = line, pos = pos + t.start, len = t.length, type = tp)
        }
    }

    fun item(ctx: ParserRuleContext) {
        when (ctx) {
            is BniParser.SectionContext -> {
                val idCtx: TerminalNode? = ctx.ID()
                if (idCtx == null) return
                semanticHub.add(idCtx, NAMESPACE)

                DocumentSymbol(
                    name = idCtx.text,
                    kind = SymbolKind.Function,
                    range = Range.of(ctx) ?: Range.zero,
                    selectionRange = Range.of(idCtx) ?: Range.zero,
                ).also {
                    documentSymbol.add(it)
                }
            }

            is BniParser.EntryContext -> {
                val idCtx: TerminalNode? = ctx.ID()
                if (idCtx == null) return
                semanticHub.add(idCtx, KEYWORD)
                value(ctx.VALUE())
            }
        }
    }

    override fun parse(stream: CharStream, states: List<LanguageState>, version: Int?) {
        if (!needParse(version)) return

        super.parse(stream, states, version)

        rootCtx = (parser as BniParser).root().also {
            it.children.forEach {
                when (it) {
                    is ParserRuleContext -> item(it)
                }
            }
        }

        for (c in tokenFactory.commentList) {
            semanticHub.add(c, COMMENT)
        }
    }
}
