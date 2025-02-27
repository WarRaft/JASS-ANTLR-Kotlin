package io.github.warraft.language._.lsp4j.service.document.semantic.token

import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.tree.TerminalNode

class SemanticTokenHub {
    val lines = mutableMapOf<Int, SemanticTokenLine>()

    fun add(
        line: Int,
        pos: Int,
        len: Int,
        type: SemanticTokenType,
        modifier: SemanticTokenModifier? = null,
    ): SemanticTokenHub {
        val t = SemanticToken(
            line = line,
            pos = pos,
            len = len,
            type = type,
            modifier = modifier
        )
        lines.getOrPut(t.line) { SemanticTokenLine(index = t.line) }.add(t)
        return this
    }

    fun add(
        s: Token?,
        type: SemanticTokenType,
        modifier: SemanticTokenModifier? = null,
    ): SemanticTokenHub = if (s == null) this else add(
        line = s.line - 1,
        pos = s.charPositionInLine,
        len = s.stopIndex - s.startIndex + 1,
        type = type,
        modifier = modifier
    )

    fun add(
        list: List<TerminalNode>, type: SemanticTokenType,
        modifier: SemanticTokenModifier? = null,
    ): SemanticTokenHub {
        for (t in list) add(t, type, modifier)
        return this
    }

    fun add(
        n: TerminalNode?,
        type: SemanticTokenType,
        modifier: SemanticTokenModifier? = null,
    ): SemanticTokenHub = if (n == null) this else add(n.symbol, type, modifier)

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
