package io.github.warraft.language.jass.antlr.psi

import io.github.warraft.language.jass.antlr.psi.JassTypeName.Companion.NULL
import io.github.warraft.language.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.language.jass.antlr.state.JassState

class JassNull(
    override val state: JassState,
) : JassNodeBase() {
    init {
        type = JassTypeName(NULL)
    }
    override fun toString(): String = "$type"
}
