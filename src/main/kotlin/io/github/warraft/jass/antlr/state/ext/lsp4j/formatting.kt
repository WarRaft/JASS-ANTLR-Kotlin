package io.github.warraft.jass.antlr.state.ext.lsp4j

import io.github.warraft.JassParser.*
import io.github.warraft.jass.antlr.state.JassState
import io.github.warraft.languages.lsp4j.LanguageServerEx
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.tree.TerminalNode
import org.eclipse.lsp4j.DocumentFormattingParams
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.Range
import org.eclipse.lsp4j.TextEdit

private class Formatter(@Suppress("unused") val server: LanguageServerEx?, val root: RootContext) {
    val fmt = mutableListOf<TextEdit>()

    fun tab(symbol: Token?, num: Int) {
        if (symbol == null) return
        var t = ""
        repeat(num) { t += "\t" }
        val char = symbol.charPositionInLine
        val l = symbol.line - 1

        //val p = num * 4
        //if (char == p) return
        fmt.add(TextEdit(Range(Position(l, 0), Position(l, char)), t))
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

            else -> server?.log("stmt: ${ctx.javaClass.simpleName}")
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


fun JassState.formattingEx(@Suppress("unused") params: DocumentFormattingParams?): List<TextEdit> {
    return Formatter(server, root).fmt
}

