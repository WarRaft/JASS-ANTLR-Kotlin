package io.github.warraft.jass.lsp4j.semantic

import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.tree.TerminalNode

class JassSemanticTokenHub {
    val lines = mutableMapOf<Int, JassSemanticTokenLine>()

    fun add(
        line: Int,
        pos: Int,
        len: Int,
        type: JassSemanticTokenType,
        modifier: JassSemanticTokenModifier? = null,
    ): JassSemanticTokenHub {
        val t = JassSemanticToken(
            line = line,
            pos = pos,
            len = len,
            type = type,
            modifier = modifier
        )
        lines.getOrPut(t.line) { JassSemanticTokenLine(index = t.line) }.add(t)
        return this
    }

    fun add(
        s: Token?,
        type: JassSemanticTokenType,
        modifier: JassSemanticTokenModifier? = null,
    ): JassSemanticTokenHub = if (s == null) this else add(
        line = s.line - 1,
        pos = s.charPositionInLine,
        len = s.stopIndex - s.startIndex + 1,
        type = type,
        modifier = modifier
    )

    fun add(
        n: TerminalNode?,
        type: JassSemanticTokenType,
        modifier: JassSemanticTokenModifier? = null,
    ): JassSemanticTokenHub = if (n == null) this else add(n.symbol, type, modifier)

    fun data(): MutableList<Int> {
        val l = mutableListOf<Int>()
        var lineLast = 0

        val lines = this.lines.values.sortedBy { it.index }
        for (line in lines) {
            val tokens = line.tokens.sortedBy { it.pos }
            var tokenLast = 0
            for ((index, token) in tokens.withIndex()) {
                l.add(if (index == 0) token.line - lineLast else 0)
                l.add(token.pos - tokenLast)
                l.add(token.len)
                l.add(token.type.ordinal)
                l.add((token.modifier?.ordinal ?: -1) + 1)
                tokenLast = token.pos
            }
            lineLast = line.index
        }

        return l
    }

    fun clear() {
        this.lines.clear()
    }
}
