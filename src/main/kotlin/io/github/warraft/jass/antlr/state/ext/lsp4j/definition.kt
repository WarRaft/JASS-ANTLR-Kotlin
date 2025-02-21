@file:Suppress("DuplicatedCode")

package io.github.warraft.jass.antlr.state.ext.lsp4j

import io.github.warraft.jass.antlr.psi.JassFun
import io.github.warraft.jass.antlr.psi.JassVar
import io.github.warraft.jass.antlr.state.JassState
import io.github.warraft.languages.lsp4j.utils.RangeEx
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.Token
import org.eclipse.lsp4j.DefinitionParams
import org.eclipse.lsp4j.LocationLink

fun JassState.definitionExt(params: DefinitionParams?): MutableList<LocationLink> {
    val defs = mutableListOf<LocationLink>()
    val position = params?.position ?: return defs
    val node = tokenTree.find(position) ?: return defs

    fun add(s: JassState, symbol: Token?, definition: ParserRuleContext?) {
        val p = s.path ?: return
        defs.add(LocationLink(p.toUri().toString(), RangeEx.get(definition), RangeEx.get(symbol)))
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
