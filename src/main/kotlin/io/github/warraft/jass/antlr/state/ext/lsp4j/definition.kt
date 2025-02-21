@file:Suppress("DuplicatedCode")

package io.github.warraft.jass.antlr.state.ext.lsp4j

import io.github.warraft.jass.antlr.psi.JassFun
import io.github.warraft.jass.antlr.psi.JassVar
import io.github.warraft.jass.antlr.state.JassState
import io.github.warraft.languages.lsp4j.utils.RangeEx
import org.eclipse.lsp4j.DefinitionParams
import org.eclipse.lsp4j.LocationLink

fun JassState.definitionExt(params: DefinitionParams?): MutableList<LocationLink> {
    val defs = mutableListOf<LocationLink>()
    val position = params?.position ?: return defs
    val node = tokenTree.find(position) ?: return defs

    fun add(v: JassVar) {
        val p = v.state.path ?: return
        defs.add(LocationLink(p.toUri().toString(), RangeEx.get(v.definition), RangeEx.get(v.symbol)))
    }

    when (node) {
        is JassVar -> {
            val s = node.scope
            if (s.function == null) {
                for (state in states + this) {
                    for (v in state.varScope.definitions(node)) add(v)
                }
            } else {
                for (v in s.definitions(node)) add(v)
            }
        }

        is JassFun -> {
            if (node.base == null) return defs
            val root = node.root
            if (root.definition == null) return defs
            val p = root.state.path ?: return defs
            defs.add(LocationLink(p.toUri().toString(), RangeEx.get(root.symbol), RangeEx.get(root.definition)))
        }
    }

    return defs
}
