package io.github.warraft.language.jass.antlr.psi

import io.github.warraft.language.jass.antlr.psi.JassTypeName.Companion.BOOLEAN
import io.github.warraft.language.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.language.jass.antlr.state.JassState

class JassBool(
    override val state: JassState,
    val raw: String,
) : JassNodeBase() {
    init {
        type = JassTypeName(BOOLEAN)
    }

    override fun toString(): String = "<$type>$raw"
}
