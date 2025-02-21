@file:Suppress("DuplicatedCode")

package io.github.warraft.jass.antlr.state.ext.lsp4j

import io.github.warraft.jass.antlr.psi.JassFun
import io.github.warraft.jass.antlr.psi.JassVar
import io.github.warraft.jass.antlr.state.JassState
import io.github.warraft.languages.lsp4j.utils.RangeEx
import org.antlr.v4.runtime.Token
import org.eclipse.lsp4j.Location
import org.eclipse.lsp4j.ReferenceParams

fun JassState.referencesExt(params: ReferenceParams?): MutableList<out Location?> {
    val refs = mutableListOf<Location>()
    val position = params?.position ?: return refs
    val node = tokenTree.find(position) ?: return refs

    fun add(s: JassState, symbol: Token?) {
        val p = s.path ?: return
        refs.add(Location(p.toUri().toString(), RangeEx.get(symbol)))
    }

    fun add(v: JassVar) = add(v.state, v.symbol)
    fun add(v: JassFun) = add(v.state, v.symbol)

    when (node) {
        is JassVar -> {
            val s = node.scope
            if (s.function == null) {
                for (state in states + this) {
                    for (v in state.varScope.usages(node)) add(v)
                }
            } else {
                for (v in s.usages(node)) add(v)
            }
        }

        is JassFun -> {
            for (s in states + this) {
                for (f in s.funScope.usages(node)) add(f)
            }
        }
    }

    return refs
}
