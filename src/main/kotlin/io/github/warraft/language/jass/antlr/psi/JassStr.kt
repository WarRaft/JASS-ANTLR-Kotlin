package io.github.warraft.language.jass.antlr.psi

import io.github.warraft.language.jass.antlr.psi.JassTypeName.Companion.STRING
import io.github.warraft.language.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.language.jass.antlr.state.JassState

class JassStr(
    override val state: JassState,
    val raw: String,
) : JassNodeBase() {
    init {
        type = JassTypeName(STRING)
    }

    override fun toString(): String = "<$type>$raw"
}
