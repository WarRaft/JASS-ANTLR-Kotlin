package io.github.warraft.jass.antlr.state.ext.lsp4j.formatting.formatter

import io.github.warraft.JassParser.*
import io.github.warraft.jass.antlr.state.JassState
import io.github.warraft.jass.antlr.state.ext.lsp4j.formatting.formatter.ext.function
import io.github.warraft.jass.antlr.state.ext.lsp4j.formatting.formatter.ext.type
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.tree.TerminalNode

import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.Range
import org.eclipse.lsp4j.TextEdit

class JassFormatter(val state: JassState, val root: ParserRuleContext) {
    val fmt = mutableListOf<TextEdit>()

    fun token(i: Int): Token? = state.tokenStream.tokens.getOrNull(i)

    fun prev(symbol: Token?): Token? {
        val i = symbol?.tokenIndex ?: return null
        return token(i - 1)
    }

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

    fun between(s: ParserRuleContext?, e: TerminalNode?, text: String) = between(s?.start, e?.symbol, text)
    fun between(s: TerminalNode?, e: ParserRuleContext?, text: String) = between(s?.symbol, e?.start, text)
    fun between(s: TerminalNode?, e: TerminalNode?, text: String) = between(s?.symbol, e?.symbol, text)
    fun between(s: Token?, e: Token?, text: String) {
        if (s == null || e == null) return
        fmt.add(
            TextEdit(
                Range(
                    Position(s.line - 1, s.charPositionInLine + (s.stopIndex - s.startIndex) + 1),
                    Position(e.line - 1, e.charPositionInLine)
                ), text
            )
        )
    }

    fun variable(ctx: VariableContext?) {
        if (ctx == null) return
        tab(ctx, 1)
    }

    fun stmt(list: List<StmtContext>?, level: Int) {
        if (list == null) return
        for (s in list) stmt(s, level)
    }

    fun stmt(ctx: ParserRuleContext?, level: Int) {
        if (ctx == null) return
        tab(ctx, level)
        when (ctx) {
            is StmtLoopContext -> {
                stmt(ctx.stmt(), level + 1)
                tab(ctx.ENDLOOP(), level)
            }

            is StmtIfContext -> {
                tab(ctx.ENDIF(), level)
                stmt(ctx.stmt(), level + 1)

                for (elseIfCtx in ctx.elseif()) {
                    tab(elseIfCtx, level)
                    stmt(elseIfCtx.stmt(), level + 1)
                }

                val elseCtx: ElseRuleContext? = ctx.elseRule()
                if (elseCtx != null) {
                    tab(elseCtx, level)
                    stmt(elseCtx.stmt(), level + 1)
                }
            }

            is StmtCallContext,
            is StmtSetContext,
            is StmtExitWhenContext,
            is StmtReturnContext,
                -> null

            else -> state.server?.log("stmt: ${ctx.javaClass.simpleName}")
        }
    }

    fun expr() {

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
