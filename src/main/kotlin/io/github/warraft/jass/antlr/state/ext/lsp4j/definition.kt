package io.github.warraft.jass.antlr.state.ext.lsp4j

import io.github.warraft.jass.antlr.psi.base.JassObjBase
import io.github.warraft.jass.antlr.state.JassState
import io.github.warraft.jass.lsp4j.utils.RangeEx
import org.eclipse.lsp4j.DefinitionParams
import org.eclipse.lsp4j.LocationLink

fun JassState.definitionExt(params: DefinitionParams?): MutableList<LocationLink> {
    val defs = mutableListOf<LocationLink>()
    val position = params?.position ?: return defs
    val node = tokenTree.find(position) ?: return defs

    if (node is JassObjBase<*>) {
        if (node.base == null) return defs
        val root = node.root
        if (root.definition == null) return defs
        val p = root.state.path ?: return defs

        defs.add(LocationLink(p.toUri().toString(), RangeEx.get(root.symbol), RangeEx.get(root.definition)))
    }
    return defs
}
