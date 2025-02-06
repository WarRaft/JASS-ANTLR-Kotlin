package io.github.warraft.jass.antlr.psi

import io.github.warraft.JassParser.ReturnRuleContext
import io.github.warraft.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.jass.antlr.psi.base.JassTypeBase

class JassReturn(
    val expr: JassExpr?,
    val ctx: ReturnRuleContext? = null,
) : JassNodeBase() {
    override var type: JassTypeBase = JassUndefinedType()
}
