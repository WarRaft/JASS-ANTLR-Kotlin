package io.github.warraft.jass.antlr.psi

import io.github.warraft.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.jass.antlr.state.JassState

class JassIf(
    override val state: JassState,
    val expr: JassExpr? = null,
) : JassNodeBase() {
    val stmt: MutableList<JassNodeBase> = mutableListOf()

    val elseifs: MutableList<JassIf> = mutableListOf()
    var elser: JassIf? = null

    override fun toString(): String = "if"
}
