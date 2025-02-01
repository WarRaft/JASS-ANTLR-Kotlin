package io.github.warraft.jass.antlr.error

class JassError(
    val id: JassErrorId,
    @Deprecated("line")
    val line: Int = 0,
    @Deprecated("char")
    val char: Int = 0,
    val message: String,
) {
    override fun toString(): String = "<$id> Line: $line, Char: $char $message"
}
