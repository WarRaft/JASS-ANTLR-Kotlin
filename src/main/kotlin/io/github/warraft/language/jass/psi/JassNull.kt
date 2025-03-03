package io.github.warraft.language.jass.psi

import io.github.warraft.language.jass.psi.JassTypeName.Companion.NULL
import io.github.warraft.language.jass.psi.base.JassNodeBase
import io.github.warraft.language.jass.state.JassState

class JassNull(
    override val state: JassState,
) : JassNodeBase() {
    init {
        type = JassTypeName(NULL)
    }
    override fun toString(): String = "$type"
}
