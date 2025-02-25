package io.github.warraft.jass.antlr.psi

import io.github.warraft.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.jass.antlr.state.JassState

class JassLoop(
    override val state: JassState,
) : JassNodeBase() {
    val stmt: MutableList<JassNodeBase> = mutableListOf()

    override fun toString(): String = "loop"
}
