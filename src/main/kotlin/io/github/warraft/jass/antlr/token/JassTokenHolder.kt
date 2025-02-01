package io.github.warraft.jass.antlr.token

import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.TerminalNode

class JassTokenHolder(
    var name: JassToken? = null,
    var type: JassToken? = null,

    ) {
    val keywords: MutableList<JassToken> = mutableListOf()

    fun sort(): JassTokenHolder {
        keywords.sortWith(compareBy<JassToken> { it.line }.thenBy { it.pos })
        return this
    }

    fun keyword(ctx: ParserRuleContext?): JassTokenHolder {
        if (ctx == null) return this
        keywords.add(JassToken(ctx))
        return this
    }

    fun keyword(ctx: TerminalNode?): JassTokenHolder {
        if (ctx == null) return this
        keywords.add(JassToken(ctx))
        return this
    }
}
