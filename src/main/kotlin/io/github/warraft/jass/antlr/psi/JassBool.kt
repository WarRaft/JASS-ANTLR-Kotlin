package io.github.warraft.jass.antlr.psi

import io.github.warraft.jass.antlr.psi.JassTypeName.Companion.BOOLEAN
import io.github.warraft.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.jass.antlr.state.JassState

class JassBool(
    override val state: JassState,
    val raw: String,
) : JassNodeBase() {
    init {
        type = JassTypeName(BOOLEAN)
    }

    override fun toString(): String = "<$type>$raw"
}
