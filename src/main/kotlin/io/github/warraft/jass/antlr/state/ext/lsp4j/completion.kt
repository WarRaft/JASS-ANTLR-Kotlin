package io.github.warraft.jass.antlr.state.ext.lsp4j

import io.github.warraft.jass.antlr.psi.JassFun
import io.github.warraft.jass.antlr.state.JassState
import org.eclipse.lsp4j.CompletionItem
import org.eclipse.lsp4j.CompletionItemKind
import org.eclipse.lsp4j.InsertTextFormat

fun JassState.completionExt(): List<CompletionItem> {
    val list = mutableListOf<CompletionItem>()

    for (k in listOf(
        "set", "call",
        "globals", "endglobals",
        "function", "takes", "returns", "nothing", "endfunction",
        "return",
        "if", "then", "else", "elseif", "endif",
        "loop", "exitwhen", "endloop",
    )) {
        list.add(CompletionItem(k).apply {
            kind = CompletionItemKind.Keyword
        })
    }

    fun type(t: String) {
        list.add(CompletionItem(t).apply {
            kind = CompletionItemKind.TypeParameter
            detail = "type"
        })
    }
    listOf("integer", "real", "boolean", "handle", "code").forEach { type(it) }

    fun function(f: JassFun) {
        list.add(CompletionItem(f.name).apply {
            kind = CompletionItemKind.Variable
            detail = "function"
            insertText = "${f.name}()"
            insertTextFormat = InsertTextFormat.PlainText
        })
    }

    fun get(state: JassState) {
        /*
        for (g in state.types) type(g.name)

         */
        for (g in state.varScope.globals) {
            list.add(CompletionItem(g.name).apply {
                kind = CompletionItemKind.Variable
                detail = "global"
            })
        }

        state.funScope.also {
            for (f in it.natives) function(f)
            for (f in it.functions) function(f)
        }
    }

    for (state in states) get(state)
    get(this)

    return list
}
