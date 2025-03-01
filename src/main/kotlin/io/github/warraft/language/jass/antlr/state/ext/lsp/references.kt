@file:Suppress("DuplicatedCode")

package io.github.warraft.language.jass.antlr.state.ext.lsp

import io.github.warraft.language.jass.antlr.psi.JassFun
import io.github.warraft.language.jass.antlr.psi.JassVar
import io.github.warraft.language.jass.antlr.state.JassState
import io.github.warraft.lsp.data.Location
import io.github.warraft.lsp.data.Position
import io.github.warraft.lsp.data.Range
import org.antlr.v4.runtime.Token

fun JassState.referencesExt(position: Position): MutableList<Location>? {
    val node = tokenTree.find(position) ?: return null

    val refs = mutableListOf<Location>()

    fun add(s: JassState, symbol: Token?) {
        val p = s.path ?: return
        val r = Range.of(symbol) ?: return

        refs.add(Location(uri = p.toUri().toString(), range = r))
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
