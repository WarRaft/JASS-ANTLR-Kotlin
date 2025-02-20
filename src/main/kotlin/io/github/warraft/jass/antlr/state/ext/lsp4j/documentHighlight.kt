@file:Suppress("DuplicatedCode")

package io.github.warraft.jass.antlr.state.ext.lsp4j

import io.github.warraft.jass.antlr.psi.JassFun
import io.github.warraft.jass.antlr.psi.JassVar
import io.github.warraft.jass.antlr.state.JassState
import io.github.warraft.jass.lsp4j.utils.RangeEx
import org.eclipse.lsp4j.DocumentHighlight
import org.eclipse.lsp4j.DocumentHighlightKind
import org.eclipse.lsp4j.DocumentHighlightParams

fun JassState.documentHighlightExt(params: DocumentHighlightParams?): List<DocumentHighlight> {
    val highlights = mutableListOf<DocumentHighlight>()
    val position = params?.position ?: return highlights
    val node = tokenTree.find(position) ?: return highlights

    fun addFun(f: JassFun) {
        if (path != f.state.path) return
        highlights.add(
            DocumentHighlight(
                RangeEx.get(f.symbol),
                DocumentHighlightKind.Write
            )
        )
    }

    when (node) {
        is JassVar -> {
            if (path != node.state?.path) return highlights
            val s = node.scope
            if (s != null) {
                val list = s.all[node.name]
                if (list != null) for (v in list) highlights.add(
                    DocumentHighlight(
                        RangeEx.get(v.symbol),
                        DocumentHighlightKind.Write
                    )
                )
            }
            server?.log("$s")

        }

        is JassFun -> {
            val root = node.root
            addFun(root)
            for (v in root.links) addFun(v)
        }
    }


    return highlights
}
