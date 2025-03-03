package io.github.warraft.language.jass.psi

import io.github.warraft.language.jass.psi.JassTypeName.Companion.STRING
import io.github.warraft.language.jass.psi.base.JassNodeBase
import io.github.warraft.language.jass.state.JassState

class JassStr(
    override val state: JassState,
    val raw: String,
) : JassNodeBase() {
    init {
        type = JassTypeName(STRING)
    }

    override fun toString(): String = "<$type>$raw"
}
