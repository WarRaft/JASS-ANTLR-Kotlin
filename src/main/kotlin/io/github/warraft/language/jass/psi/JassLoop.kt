package io.github.warraft.language.jass.psi

import io.github.warraft.language.jass.psi.base.JassNodeBase
import io.github.warraft.language.jass.state.JassState

class JassLoop(
    override val state: JassState,
) : JassNodeBase() {
    val stmt: MutableList<JassNodeBase> = mutableListOf()

    override fun toString(): String = "loop"
}
