package io.github.warraft.jass.antlr.utils

import io.github.warraft.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.jass.antlr.psi.JassFun
import io.github.warraft.jass.antlr.psi.JassVar
import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.tree.TerminalNode
import org.eclipse.lsp4j.Position
import java.util.TreeMap

class JassTokenTree {
    private val lines = mutableMapOf<Int, TreeMap<Int, Holder>>()

    fun add(v: JassFun?) = add(v, v?.symbol)
    fun add(v: JassVar?) = add(v, v?.symbol)

    fun add(node: JassNodeBase?, token: Token?) {
        if (node == null || token == null) return
        val l = lines.getOrPut(token.line) { TreeMap<Int, Holder>() }
        l[token.charPositionInLine] = Holder(node, token)
    }

    fun add(node: JassNodeBase?, token: TerminalNode?) {
        if (node == null || token == null) return
        add(node, token.symbol)
    }

    fun find(pos: Position?): JassNodeBase? {
        if (pos == null) return null
        val l = lines[pos.line + 1] ?: return null

        val entry = l.floorEntry(pos.character) ?: return null
        return entry.value.takeIf { it.token.charPositionInLine + it.token.stopIndex - it.token.startIndex + 1 >= pos.character }?.node
    }

    fun clear() {
        lines.clear()
    }

    companion object {
        private class Holder(val node: JassNodeBase, val token: Token)
    }
}
