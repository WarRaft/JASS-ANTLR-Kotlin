package io.github.warraft.language.jass.psi

import io.github.warraft.language.jass.psi.JassTypeName.Companion.BOOLEAN
import io.github.warraft.language.jass.psi.base.JassNodeBase
import io.github.warraft.language.jass.state.JassState

class JassBool(
    override val state: JassState,
    val raw: String,
) : JassNodeBase() {
    init {
        type = JassTypeName(BOOLEAN)
    }

    override fun toString(): String = "<$type>$raw"
}
