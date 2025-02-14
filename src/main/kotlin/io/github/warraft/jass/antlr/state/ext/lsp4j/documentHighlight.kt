package io.github.warraft.jass.antlr.state.ext.lsp4j

import io.github.warraft.jass.antlr.psi.base.JassObjBase
import io.github.warraft.jass.antlr.state.JassState
import io.github.warraft.jass.lsp4j.utils.RangeEx
import org.eclipse.lsp4j.DocumentHighlight
import org.eclipse.lsp4j.DocumentHighlightKind
import org.eclipse.lsp4j.DocumentHighlightParams

fun JassState.documentHighlightExt(params: DocumentHighlightParams?): List<DocumentHighlight> {
    val highlights = mutableListOf<DocumentHighlight>()
    val position = params?.position ?: return highlights
    val node = tokenTree.find(position) ?: return highlights

    fun addObj(v: JassObjBase<*>) {
        if (path == null || path != v.state.path) return
        server?.log("${this === v.state}")

        highlights.add(
            DocumentHighlight(
                RangeEx.get(v.symbol),
                DocumentHighlightKind.Write
            )
        )
    }

    when (node) {
        is JassObjBase<*> -> {
            val root = node.root
            addObj(root)
            for (v in root.links) addObj(v)
        }
    }

    return highlights
}
