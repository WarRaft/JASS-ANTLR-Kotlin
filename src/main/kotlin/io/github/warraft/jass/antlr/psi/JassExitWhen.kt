package io.github.warraft.jass.antlr.psi

import io.github.warraft.jass.antlr.JassParser.ExitwhenContext

class JassExitWhen(
    val expr: JassExpr,
    var ctx: ExitwhenContext? = null,
) : IJassNode() {
    override var type: IJassType = JassUndefinedType()
}
