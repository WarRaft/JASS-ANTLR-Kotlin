package io.github.warraft.jass.antlr.state.ext

import io.github.warraft.jass.antlr.psi.JassVar
import io.github.warraft.jass.antlr.state.JassState
import io.github.warraft.jass.lsp4j.utils.RangeEx
import org.eclipse.lsp4j.DocumentHighlight
import org.eclipse.lsp4j.DocumentHighlightKind
import org.eclipse.lsp4j.Location
import org.eclipse.lsp4j.ReferenceParams

fun JassState.references(params: ReferenceParams?): MutableList<out Location?> {
    val refs = mutableListOf<Location>()
    val position = params?.position ?: return refs
    val node = tokenTree.find(position) ?: return refs

    /*
    fun addVar(v: JassVar) {
        refs.add(
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
 */
    return refs
}
