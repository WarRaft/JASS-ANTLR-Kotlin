package io.github.warraft.language.jass.antlr.state.ext.lsp.formatting.formatter

import io.github.warraft.JassParser.*
import io.github.warraft.language.jass.antlr.state.JassState
import io.github.warraft.language.jass.antlr.state.ext.lsp.formatting.formatter.ext.expr
import io.github.warraft.language.jass.antlr.state.ext.lsp.formatting.formatter.ext.function
import io.github.warraft.language.jass.antlr.state.ext.lsp.formatting.formatter.ext.type
import io.github.warraft.language.jass.antlr.state.ext.lsp.formatting.formatter.ext.variable
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.tree.TerminalNode

import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.Range
import org.eclipse.lsp4j.TextEdit

class JassFormatter(val state: JassState, val root: ParserRuleContext) {
    val fmt = mutableListOf<TextEdit>()

    fun token(i: Int): Token? = state.tokenStream.tokens.getOrNull(i)

    fun prev(ctx: ParserRuleContext): Token? = prev(ctx.start)
    fun prev(symbol: Token?): Token? {
        val i = symbol?.tokenIndex ?: return null
        return token(i - 1)
    }

    fun next(ctx: ParserRuleContext): Token? = next(ctx.stop)
    fun next(node: TerminalNode?): Token? = next(node?.symbol)
    fun next(symbol: Token?): Token? {
        val i = symbol?.tokenIndex ?: return null
        return token(i + 1)
    }

    fun tab(symbol: Token?, num: Int) {
        if (symbol == null) return
        var t = ""
        repeat(num) { t += "\t" }

        var start = 0
        val stop = symbol.charPositionInLine
        val line = symbol.line - 1

        val prev = prev(symbol)

        if (prev != null && prev.line == symbol.line) {
            t = "\n" + t
            start = prev.charPositionInLine + (prev.stopIndex - prev.startIndex) + 1
        }
        fmt.add(TextEdit(Range(Position(line, start), Position(line, stop)), t))
    }

    fun tab(node: TerminalNode?, num: Int) = tab(node?.symbol, num)
    fun tab(ctx: ParserRuleContext?, num: Int) = tab(ctx?.start, num)

    fun between(s: ParserRuleContext?, e: ParserRuleContext?, count: Int) = between(s?.stop, e?.start, count)
    fun between(s: ParserRuleContext?, e: TerminalNode?, count: Int) = between(s?.stop, e?.symbol, count)
    fun between(s: ParserRuleContext?, e: Token?, count: Int) = between(s?.stop, e, count)

    fun between(s: TerminalNode?, e: ParserRuleContext?, count: Int) = between(s?.symbol, e?.start, count)
    fun between(s: Token?, e: ParserRuleContext?, count: Int) = between(s, e?.start, count)

    fun between(s: TerminalNode?, e: TerminalNode?, count: Int) = between(s?.symbol, e?.symbol, count)
    fun between(s: Token?, e: Token?, count: Int) {
        if (s == null || e == null) return
        var t = ""
        repeat(count) { t += " " }

        if (next(s) != e || prev(e) != s) {
            state.server?.log("🔥 between: ${s.line} | ${e.line} ")
            return
        }

        fmt.add(
            TextEdit(
                Range(
                    Position(s.line - 1, s.charPositionInLine + (s.stopIndex - s.startIndex) + 1),
                    Position(e.line - 1, e.charPositionInLine)
                ), t
            )
        )
    }

    fun paren(list: List<ExprContext>, lpCtx: TerminalNode?, rpCtx: TerminalNode?) {
        if (list.isEmpty()) {
            between(lpCtx, rpCtx, 0)
            return
        }
        for (eCtx in list) {
            val prev = prev(eCtx)
            when (prev?.type) {
                COMMA -> between(prev, eCtx, 1)
                LPAREN -> between(prev, eCtx, 0)
            }
            val next = next(eCtx)
            when (next?.type) {
                COMMA, RPAREN -> between(eCtx, next, 0)
            }
            expr(eCtx)
        }
    }

    fun trail(ctx: ParserRuleContext?) {
        val stop = ctx?.stop ?: return
        val next = next(stop) ?: return
        if (next.type != LINE_COMMENT) return
        if (stop.line != next.line) return
        between(stop, next, 1)
    }

    fun format() {
        for (ctx in root.children) {
            when (ctx) {
                is GlobalsContext -> {
                    tab(ctx.GLOBALS(), 0)
                    tab(ctx.ENDGLOBALS(), 0)
                    for (v in ctx.variable()) variable(v)
                }

                is TypeContext -> type(ctx)
                is NativeRuleContext -> function(ctx)
                is FunctionContext -> function(ctx)
            }
        }
    }

    init {
        format()
    }
}
