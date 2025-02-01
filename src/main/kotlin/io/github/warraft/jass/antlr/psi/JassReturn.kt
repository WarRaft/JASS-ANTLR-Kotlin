package io.github.warraft.jass.antlr.psi

import io.github.warraft.jass.antlr.JassParser.ReturnRuleContext

class JassReturn(
    val expr: JassExpr?,
    val ctx: ReturnRuleContext? = null,
) : IJassNode() {
    override var type: IJassType = JassUndefinedType()
}
