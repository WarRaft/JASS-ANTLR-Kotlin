package io.github.warraft.jass.antlr.psi

import io.github.warraft.JassParser.ExitwhenContext
import io.github.warraft.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.jass.antlr.psi.base.JassTypeBase

class JassExitWhen(
    val expr: JassExpr,
    var ctx: ExitwhenContext? = null,
) : JassNodeBase() {
    override var type: JassTypeBase = JassUndefinedType()
}
