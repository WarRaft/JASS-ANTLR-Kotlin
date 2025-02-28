package io.github.warraft.language.jass.antlr.state.ext.lsp4j

import io.github.warraft.language.jass.antlr.psi.JassFun
import io.github.warraft.language.jass.antlr.state.JassState
import io.github.warraft.lsp.data.CompletionItem
import io.github.warraft.lsp.data.CompletionItemKind

fun JassState.completionExt() {
    val list = completion.items.apply { clear() }

    for (k in listOf(
        "set", "call",
        "globals", "endglobals",
        "function", "takes", "returns", "nothing", "endfunction",
        "return",
        "if", "then", "else", "elseif", "endif",
        "loop", "exitwhen", "endloop",
    )) {
        list.add(
            CompletionItem(
                label = k,
                kind = CompletionItemKind.Keyword,
            )
        )
    }

    fun type(t: String) {
        list.add(
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
        list.add(
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
            list.add(
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
}
