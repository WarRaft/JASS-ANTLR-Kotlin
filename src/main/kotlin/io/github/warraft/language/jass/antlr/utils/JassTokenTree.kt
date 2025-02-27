package io.github.warraft.language.jass.antlr.utils

import io.github.warraft.language.jass.antlr.psi.base.JassNodeBase
import org.antlr.v4.runtime.Token
import org.eclipse.lsp4j.Position
import java.util.*

class JassTokenTree {
    private val lines = mutableMapOf<Int, TreeMap<Int, Holder>>()

    fun add(node: JassNodeBase?) {
        val token = node?.symbol ?: return
        val l = lines.getOrPut(token.line) { TreeMap<Int, Holder>() }
        l[token.charPositionInLine] = Holder(node, token)
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
