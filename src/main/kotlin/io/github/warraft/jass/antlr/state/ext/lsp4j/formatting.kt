package io.github.warraft.jass.antlr.state.ext.lsp4j

import io.github.warraft.JassParser.*
import io.github.warraft.jass.antlr.state.JassState
import io.github.warraft.languages.lsp4j.LanguageServerEx
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
        val p = num * 4
        val l = symbol.line - 1
        if (char == p) return
        fmt.add(TextEdit(Range(Position(l, 0), Position(l, char)), t))
    }

    fun tab(node: TerminalNode?, num: Int) {
        tab(node?.symbol, num)
    }

    fun format() {
        root.children.forEach {
            when (it) {
                is GlobalsContext -> {
                    tab(it.GLOBALS(), 0)
                    tab(it.ENDGLOBALS(), 0)
                }
                /*
                is TypeContext -> typedef(it)
                is NativeRuleContext -> JassFun.parse(it, null, this)
                is FunctionContext -> JassFun.parse(it, null, this)
                 */
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

