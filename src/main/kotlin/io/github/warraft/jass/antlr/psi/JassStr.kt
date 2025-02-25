package io.github.warraft.jass.antlr.psi

import io.github.warraft.jass.antlr.psi.JassTypeName.Companion.STRING
import io.github.warraft.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.jass.antlr.state.JassState

class JassStr(
    override val state: JassState,
    val raw: String,
) : JassNodeBase() {
    init {
        type = JassTypeName(STRING)
    }

    override fun toString(): String = "<$type>$raw"
}
