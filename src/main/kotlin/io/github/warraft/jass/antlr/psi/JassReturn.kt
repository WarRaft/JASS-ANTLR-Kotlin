package io.github.warraft.jass.antlr.psi

import io.github.warraft.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.jass.antlr.psi.base.JassTypeBase

class JassReturn(
    val expr: JassExpr?,
) : JassNodeBase() {
    override var type: JassTypeBase = JassUndefinedType()
}
