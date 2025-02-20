@file:Suppress("DuplicatedCode")

package io.github.warraft.jass.antlr.state.ext.lsp4j

import io.github.warraft.jass.antlr.psi.JassFun
import io.github.warraft.jass.antlr.psi.JassVar
import io.github.warraft.jass.antlr.state.JassState
import io.github.warraft.jass.lsp4j.utils.RangeEx
import org.eclipse.lsp4j.DefinitionParams
import org.eclipse.lsp4j.LocationLink

fun JassState.definitionExt(params: DefinitionParams?): MutableList<LocationLink> {
    val defs = mutableListOf<LocationLink>()
    val position = params?.position ?: return defs
    val node = tokenTree.find(position) ?: return defs

    fun add(v: JassVar?) {
        if (v == null) return
        val p = v.state?.path ?: return
        if (v.symbol == null || v.definition == null) return
        defs.add(LocationLink(p.toUri().toString(), RangeEx.get(v.definition), RangeEx.get(v.symbol)))
    }

    if (node is JassVar) {
        val state = node.state ?: return defs
        var v = node.scope?.definition(node.name)
        if (v == null) {
            for (s in state.states) {
                v = s.scopeVar.definition(node.name)
                if (v != null) break
            }
        }
        add(v)
    }

    if (node is JassFun) {
        if (node.base == null) return defs
        val root = node.root
        if (root.definition == null) return defs
        val p = root.state.path ?: return defs
        defs.add(LocationLink(p.toUri().toString(), RangeEx.get(root.symbol), RangeEx.get(root.definition)))
    }

    return defs
}
