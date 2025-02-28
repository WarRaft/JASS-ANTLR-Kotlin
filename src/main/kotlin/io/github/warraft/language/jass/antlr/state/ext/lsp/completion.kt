package io.github.warraft.language.jass.antlr.state.ext.lsp

import io.github.warraft.language.jass.antlr.psi.JassFun
import io.github.warraft.language.jass.antlr.state.JassState
import io.github.warraft.lsp.data.CompletionItem
import io.github.warraft.lsp.data.CompletionItemKind
import io.github.warraft.lsp.data.CompletionList

fun JassState.completionExt(): CompletionList? {
    val list = CompletionList()
    val items = list.items

    for (k in listOf(
        "set", "call",
        "globals", "endglobals",
        "function", "takes", "returns", "nothing", "endfunction",
        "return",
        "if", "then", "else", "elseif", "endif",
        "loop", "exitwhen", "endloop",
    )) {
        items.add(
            CompletionItem(
                label = k,
                kind = CompletionItemKind.Keyword,
            )
        )
    }

    fun type(t: String) {
        items.add(
            CompletionItem(
                label = t,
                kind = CompletionItemKind.TypeParameter,
                detail = "type",
            )
        )
    }
    listOf("integer", "real", "boolean", "handle", "code").forEach { type(it) }

    fun function(f: JassFun) {
        val name = f.name ?: return
        items.add(
            CompletionItem(
                label = name,
                kind = CompletionItemKind.Variable,
                detail = "function",
                insertText = "${f.name}()"
            )
        )
    }

    for (s in states + this) {
        /*
        for (g in state.types) type(g.name)
         */
        for (g in s.varScope.globals) {
            val name = g.name ?: continue
            items.add(
                CompletionItem(
                    label = name,
                    kind = CompletionItemKind.Variable,
                    detail = "global"
                )
            )
        }

        s.funScope.also {
            for (f in it.natives) function(f)
            for (f in it.functions) function(f)
        }
    }

    return list
}
