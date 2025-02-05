package io.github.warraft.jass.antlr.utils

import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CommonToken
import org.antlr.v4.runtime.CommonTokenFactory
import org.antlr.v4.runtime.TokenSource
import org.antlr.v4.runtime.misc.Pair

class JassTokenFactory(val map: MutableMap<Int, CommonToken>) : CommonTokenFactory() {
    val comments = mutableListOf<CommonToken>()

    override fun create(
        source: Pair<TokenSource?, CharStream?>?,
        type: Int,
        text: String?,
        channel: Int,
        start: Int,
        stop: Int,
        line: Int,
        charPositionInLine: Int,
    ): CommonToken? {
        var t = super.create(source, type, text, channel, start, stop, line, charPositionInLine)
        if (t.channel == 2) {
            map[line] = t
            comments.add(t)
        }
        return t
    }
}
