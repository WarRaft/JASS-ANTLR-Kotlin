package io.github.warraft.jass.antlr.error

import io.github.warraft.jass.antlr.token.JassToken

class JassError(
    val id: JassErrorId,
    @Deprecated("line")
    val line: Int,
    @Deprecated("char")
    val char: Int,
    val message: String,
    val token: JassToken? = null,
) {
    override fun toString(): String = "<$id> Line: $line, Char: $char $message"
}
