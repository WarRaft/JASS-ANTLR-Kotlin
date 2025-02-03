package io.github.warraft.jass.antlr.state.ext

import io.github.warraft.jass.antlr.psi.JassFun
import io.github.warraft.jass.antlr.state.JassState
import org.eclipse.lsp4j.CompletionItem
import org.eclipse.lsp4j.CompletionItemKind
import org.eclipse.lsp4j.InsertTextFormat

fun JassState.completion(): List<CompletionItem> {
    val list = mutableListOf<CompletionItem>()

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
        for (g in state.types) type(g.name)
        for (g in state.globals) {
            list.add(CompletionItem(g.name).apply {
                kind = CompletionItemKind.Variable
                detail = "global"
            })
        }
        for (f in state.natives) function(f)
        for (f in state.functions) function(f)
    }

    for (state in states) get(state)
    get(this)

    return list
}
