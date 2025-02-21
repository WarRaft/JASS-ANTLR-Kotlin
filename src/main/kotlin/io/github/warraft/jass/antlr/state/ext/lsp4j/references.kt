@file:Suppress("DuplicatedCode")

package io.github.warraft.jass.antlr.state.ext.lsp4j

import io.github.warraft.jass.antlr.psi.JassFun
import io.github.warraft.jass.antlr.psi.JassVar
import io.github.warraft.jass.antlr.state.JassState
import io.github.warraft.languages.lsp4j.utils.RangeEx
import org.eclipse.lsp4j.Location
import org.eclipse.lsp4j.ReferenceParams

fun JassState.referencesExt(params: ReferenceParams?): MutableList<out Location?> {
    val refs = mutableListOf<Location>()
    val position = params?.position ?: return refs
    val node = tokenTree.find(position) ?: return refs


    fun addVar(v: JassVar) {
        val p = v.state.path ?: return
        refs.add(Location(p.toUri().toString(), RangeEx.get(v.symbol)))
    }

    fun addFun(v: JassFun) {
        val p = v.state.path ?: return
        refs.add(Location(p.toUri().toString(), RangeEx.get(v.symbol)))
    }

    when (node) {
        is JassVar -> {
            //val root = node.root
            //addVar(root)
            //for (v in root.links) addVar(v)
        }

        is JassFun -> {
            val root = node.root
            addFun(root)
            for (v in root.links) addFun(v)
        }
    }

    return refs
}
