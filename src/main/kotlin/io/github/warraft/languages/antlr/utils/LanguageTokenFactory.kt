package io.github.warraft.languages.antlr.utils

import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CommonToken
import org.antlr.v4.runtime.CommonTokenFactory
import org.antlr.v4.runtime.TokenSource
import org.antlr.v4.runtime.misc.Pair

class LanguageTokenFactory() : CommonTokenFactory() {
    val commentList = mutableListOf<CommonToken>()
    val commentMap = mutableMapOf<Int, CommonToken>()

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
            commentList.add(t)
            commentMap[line] = t

        }
        return t
    }

    fun clear() {
        commentList.clear()
        commentMap.clear()
    }
}
