package io.github.warraft.language.jass.psi

import io.github.warraft.language.jass.psi.JassTypeName.Companion.REAL
import io.github.warraft.language.jass.psi.base.JassNodeBase
import io.github.warraft.language.jass.state.JassState

class JassReal(
    override val state: JassState,
    val raw: String,
) : JassNodeBase() {
    init {
        type = JassTypeName(REAL)
    }

    override fun toString(): String = "<$type>$raw"
}
