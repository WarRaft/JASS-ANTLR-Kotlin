package io.github.warraft.jass.antlr.error

import io.github.warraft.jass.antlr.token.JassToken

class JassError(
    val id: JassErrorId,
    @Deprecated("line")
    val line: Int = 0,
    @Deprecated("char")
    val char: Int = 0,
    val message: String,
    val token: JassToken? = null,
) {
    override fun toString(): String = "<$id> Line: $line, Char: $char $message"
}
