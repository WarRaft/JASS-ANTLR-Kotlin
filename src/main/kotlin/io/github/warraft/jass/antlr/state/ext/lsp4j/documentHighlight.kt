@file:Suppress("DuplicatedCode")

package io.github.warraft.jass.antlr.state.ext.lsp4j

import io.github.warraft.jass.antlr.psi.JassFun
import io.github.warraft.jass.antlr.psi.JassType
import io.github.warraft.jass.antlr.psi.JassVar
import io.github.warraft.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.jass.antlr.state.JassState
import io.github.warraft.languages.lsp4j.utils.RangeEx
import org.eclipse.lsp4j.DocumentHighlight
import org.eclipse.lsp4j.DocumentHighlightKind
import org.eclipse.lsp4j.DocumentHighlightParams

fun JassState.documentHighlightExt(params: DocumentHighlightParams?): List<DocumentHighlight> {
    val highlights = mutableListOf<DocumentHighlight>()
    val position = params?.position ?: return highlights
    val node = tokenTree.find(position) ?: return highlights

    fun base(list: List<JassNodeBase>) {
        for (v in list) {
            if (path != v.state.path) continue
            highlights.add(
                DocumentHighlight(
                    RangeEx.get(v.symbol),
                    DocumentHighlightKind.Write
                )
            )
        }
    }

    when (node) {
        is JassType -> base(typeScope.usages(node))
        is JassVar -> base(node.scope.usages(node))
        is JassFun -> base(node.scope.usages(node))
    }

    return highlights
}
