package io.github.warraft.jass.antlr.state.ext.lsp4j

import io.github.warraft.jass.antlr.psi.base.JassObjBase
import io.github.warraft.jass.antlr.state.JassState
import io.github.warraft.jass.lsp4j.utils.RangeEx
import org.eclipse.lsp4j.Location
import org.eclipse.lsp4j.ReferenceParams

fun JassState.referencesExt(params: ReferenceParams?): MutableList<out Location?> {
    val refs = mutableListOf<Location>()
    val position = params?.position ?: return refs
    val node = tokenTree.find(position) ?: return refs

    fun addObj(v: JassObjBase<*>) {
        val p = v.state.path ?: return
        refs.add(Location(p.toUri().toString(), RangeEx.get(v.symbol)))
    }

    when (node) {
        is JassObjBase<*> -> {
            val root = node.root
            addObj(root)
            for (v in root.links) addObj(v)
        }
    }
    return refs
}
