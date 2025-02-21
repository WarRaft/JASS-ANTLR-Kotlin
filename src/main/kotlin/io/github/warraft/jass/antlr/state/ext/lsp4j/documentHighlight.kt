@file:Suppress("DuplicatedCode")

package io.github.warraft.jass.antlr.state.ext.lsp4j

import io.github.warraft.jass.antlr.psi.JassFun
import io.github.warraft.jass.antlr.psi.JassVar
import io.github.warraft.jass.antlr.state.JassState
import io.github.warraft.languages.lsp4j.utils.RangeEx
import org.eclipse.lsp4j.DocumentHighlight
import org.eclipse.lsp4j.DocumentHighlightKind
import org.eclipse.lsp4j.DocumentHighlightParams

fun JassState.documentHighlightExt(params: DocumentHighlightParams?): List<DocumentHighlight> {
    val highlights = mutableListOf<DocumentHighlight>()
    val position = params?.position ?: return highlights
    val node = tokenTree.find(position) ?: return highlights

    when (node) {
        is JassVar -> {
            for (v in node.scope.usages(node)) {
                if (path != v.state.path) continue
                highlights.add(
                    DocumentHighlight(
                        RangeEx.get(v.symbol),
                        DocumentHighlightKind.Write
                    )
                )
            }
        }

        is JassFun -> {
            for (f in node.scope.usages(node)) {
                if (path != f.state.path) continue
                highlights.add(
                    DocumentHighlight(
                        RangeEx.get(f.symbol),
                        DocumentHighlightKind.Write
                    )
                )
            }
        }
    }

    return highlights
}
