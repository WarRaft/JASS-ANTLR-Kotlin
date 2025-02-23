package io.github.warraft.jass.antlr.state.ext.lsp4j

import io.github.warraft.JassParser.*
import io.github.warraft.jass.antlr.state.JassState
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.tree.TerminalNode
import org.eclipse.lsp4j.DocumentFormattingParams
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.Range
import org.eclipse.lsp4j.TextEdit

private class Formatter(val state: JassState, val root: ParserRuleContext) {
    val fmt = mutableListOf<TextEdit>()

    fun tab(symbol: Token?, num: Int) {
        if (symbol == null) return
        var t = ""
        repeat(num) { t += "\t" }

        var start = 0
        val stop = symbol.charPositionInLine
        val line = symbol.line - 1

        val prev = state.tokenStream.tokens.getOrNull(symbol.tokenIndex - 1)

        if (prev != null && prev.line == symbol.line) {
            t = "\n" + t
            start = prev.charPositionInLine + (prev.stopIndex - prev.startIndex) + 1
        }
        fmt.add(TextEdit(Range(Position(line, start), Position(line, stop)), t))
    }

    fun tab(node: TerminalNode?, num: Int) = tab(node?.symbol, num)
    fun tab(ctx: ParserRuleContext?, num: Int) = tab(ctx?.start, num)

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

                is TypeContext -> {
                    tab(ctx, 0)
                }

                is NativeRuleContext -> {
                    tab(ctx, 0)
                }

                is FunctionContext -> {
                    tab(ctx, 0)
                    for (v in ctx.variable()) variable(v)
                    stmt(ctx.stmt(), 1)
                }
            }
        }

    }

    init {
        format()
    }
}

fun JassState.formattingEx(@Suppress("unused") params: DocumentFormattingParams?): List<TextEdit> = Formatter(this, rootCtx).fmt

