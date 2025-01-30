package io.github.warraft.jass.antlr.psi

import org.antlr.v4.runtime.ParserRuleContext

class JassIf(
    val expr: JassExpr? = null,
    val ctx: ParserRuleContext? = null,
) : IJassNode {
    override var type: IJassType = JassUndefinedType()

    val stmt: MutableList<IJassNode> = mutableListOf()

    val elseifs: MutableList<JassIf> = mutableListOf()
    var elser: JassIf? = null

    override fun toString(): String = "if"
}
