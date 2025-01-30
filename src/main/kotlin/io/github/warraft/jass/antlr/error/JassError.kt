package io.github.warraft.jass.antlr.error

class JassError(
    val id: JassErrorId,
    val line: Int,
    val char: Int,
    val message: String,
) {
    override fun toString(): String = "<$id> Line: $line, Char: $char $message"
}
