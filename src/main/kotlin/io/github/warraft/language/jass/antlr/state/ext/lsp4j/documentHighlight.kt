@file:Suppress("DuplicatedCode")

package io.github.warraft.language.jass.antlr.state.ext.lsp4j

import io.github.warraft.language.jass.antlr.psi.JassFun
import io.github.warraft.language.jass.antlr.psi.JassType
import io.github.warraft.language.jass.antlr.psi.JassVar
import io.github.warraft.language.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.language.jass.antlr.state.JassState
import io.github.warraft.lsp.data.DocumentHighlight
import io.github.warraft.lsp.data.DocumentHighlightKind
import io.github.warraft.lsp.data.Position
import io.github.warraft.lsp.data.Range

fun JassState.documentHighlightExt(position: Position): List<DocumentHighlight>? {
    val node = tokenTree.find(position) ?: return null

    val highlights = mutableListOf<DocumentHighlight>()

    fun base(list: List<JassNodeBase>) {
        for (v in list) {
            if (path != v.state.path) continue
            val r = Range.of(v.symbol) ?: continue
            highlights.add(DocumentHighlight(r, DocumentHighlightKind.Write))
        }
    }

    when (node) {
        is JassType -> base(typeScope.usages(node))
        is JassVar -> base(node.scope.usages(node))
        is JassFun -> base(node.scope.usages(node))
    }

    return highlights
}
