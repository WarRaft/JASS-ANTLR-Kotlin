@file:Suppress("DuplicatedCode")

package io.github.warraft.language.jass.state.ext.lsp

import io.github.warraft.language.jass.psi.JassFun
import io.github.warraft.language.jass.psi.JassVar
import io.github.warraft.language.jass.state.JassState
import io.github.warraft.lsp.data.LocationLink
import io.github.warraft.lsp.data.Position
import io.github.warraft.lsp.data.Range
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.Token

fun JassState.definitionExt(position: Position): MutableList<LocationLink>? {
    val node = tokenTree.find(position) ?: return null
    val defs = mutableListOf<LocationLink>()

    fun add(s: JassState, symbol: Token?, definition: ParserRuleContext?) {
        val p = s.path ?: return

        val targetRange = Range.of(definition) ?: return
        val targetSelectionRange = Range.of(symbol) ?: return

        defs.add(
            LocationLink(
                targetUri = p.toUri().toString(),
                targetRange = targetRange,
                targetSelectionRange = targetSelectionRange
            )
        )
    }

    fun add(v: JassVar) = add(v.state, v.symbol, v.definition)
    fun add(f: JassFun) = add(f.state, f.symbol, f.definition)

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
            for (s in states + this) {
                for (f in s.funScope.definitions(node)) add(f)
            }
        }
    }

    return defs
}
