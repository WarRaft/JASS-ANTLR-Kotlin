package io.github.warraft.language.jass.antlr.psi

import io.github.warraft.language.jass.antlr.psi.JassTypeName.Companion.REAL
import io.github.warraft.language.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.language.jass.antlr.state.JassState

class JassReal(
    override val state: JassState,
    val raw: String,
) : JassNodeBase() {
    init {
        type = JassTypeName(REAL)
    }

    override fun toString(): String = "<$type>$raw"
}
