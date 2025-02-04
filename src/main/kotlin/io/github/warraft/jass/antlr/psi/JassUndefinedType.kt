package io.github.warraft.jass.antlr.psi

import io.github.warraft.jass.antlr.psi.base.JassTypeBase

class JassUndefinedType : JassTypeBase() {
    override val name: String = "undefined"

    override fun op(op: JassExprOp, b: JassTypeBase): JassTypeBase = JassUndefinedType()
}
