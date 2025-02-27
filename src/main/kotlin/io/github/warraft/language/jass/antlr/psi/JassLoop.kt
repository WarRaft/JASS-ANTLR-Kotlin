package io.github.warraft.language.jass.antlr.psi

import io.github.warraft.language.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.language.jass.antlr.state.JassState

class JassLoop(
    override val state: JassState,
) : JassNodeBase() {
    val stmt: MutableList<JassNodeBase> = mutableListOf()

    override fun toString(): String = "loop"
}
