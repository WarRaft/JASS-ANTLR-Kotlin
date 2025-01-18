package io.github.warraft.jass.antlr.error

class JassError(val jassErrorId: JassErrorId, val line: Int, val char: Int, val message: String) {
    override fun toString(): String = "$jassErrorId [$line:$char] $message"
}
