package io.github.warraft.jass.antlr.psi

import io.github.warraft.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.jass.antlr.psi.base.JassTypeBase

class JassIf(
    val expr: JassExpr? = null,
) : JassNodeBase() {
    override var type: JassTypeBase = JassUndefinedType()

    val stmt: MutableList<JassNodeBase> = mutableListOf()

    val elseifs: MutableList<JassIf> = mutableListOf()
    var elser: JassIf? = null

    override fun toString(): String = "if"
}
