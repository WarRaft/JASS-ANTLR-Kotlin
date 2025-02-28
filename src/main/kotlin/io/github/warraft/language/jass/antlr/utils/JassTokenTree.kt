package io.github.warraft.language.jass.antlr.utils

import io.github.warraft.language.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.lsp.data.Position
import org.antlr.v4.runtime.Token

import java.util.*

class JassTokenTree {
    private val lines = mutableMapOf<Int, TreeMap<Int, Holder>>()

    fun add(node: JassNodeBase?) {
        val token = node?.symbol ?: return
        val l = lines.getOrPut(token.line) { TreeMap<Int, Holder>() }
        l[token.charPositionInLine] = Holder(node, token)
    }

    fun find(pos: org.eclipse.lsp4j.Position?): JassNodeBase? {
        if (pos == null) return null
        val l = lines[pos.line + 1] ?: return null

        val entry = l.floorEntry(pos.character) ?: return null
        return entry.value.takeIf { it.token.charPositionInLine + it.token.stopIndex - it.token.startIndex + 1 >= pos.character }?.node
    }

    fun find(pos: Position?): JassNodeBase? {
        if (pos == null) return null
        val ll = pos.line.toInt()
        val ch = pos.character.toInt()

        val l = lines[ll + 1] ?: return null

        val entry = l.floorEntry(ch) ?: return null
        return entry.value.takeIf { it.token.charPositionInLine + it.token.stopIndex - it.token.startIndex + 1 >= ch }?.node
    }

    fun clear() {
        lines.clear()
    }

    companion object {
        private class Holder(val node: JassNodeBase, val token: Token)
    }
}
