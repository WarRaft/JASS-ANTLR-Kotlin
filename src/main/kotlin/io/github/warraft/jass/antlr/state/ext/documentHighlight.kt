package io.github.warraft.jass.antlr.state.ext

import io.github.warraft.jass.antlr.psi.JassVar
import io.github.warraft.jass.antlr.state.JassState
import io.github.warraft.jass.lsp4j.utils.RangeEx
import org.eclipse.lsp4j.DocumentHighlight
import org.eclipse.lsp4j.DocumentHighlightKind
import org.eclipse.lsp4j.DocumentHighlightParams

fun JassState.documentHighlight(params: DocumentHighlightParams?): List<DocumentHighlight> {
    val highlights = mutableListOf<DocumentHighlight>()
    val position = params?.position ?: return highlights
    val node = tokenTree.find(position) ?: return highlights

    fun addVar(v: JassVar) {
        highlights.add(
            DocumentHighlight(
                RangeEx.get(v.symbol),
                DocumentHighlightKind.Write
            )
        )
    }

    when (node) {
        is JassVar -> {
            val root = node.root
            addVar(root)
            for (v in root.links) addVar(v)
        }
    }

    return highlights
}
