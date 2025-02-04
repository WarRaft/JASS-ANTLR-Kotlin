package io.github.warraft.jass.antlr.psi

import io.github.warraft.jass.antlr.psi.base.JassTypeBase

class JassCodeType() : JassTypeBase() {
    override val name: String = "code"
    override fun op(op: JassExprOp, b: JassTypeBase): JassTypeBase {
        return when (op) {
            JassExprOp.Set -> when (b) {
                is JassCodeType,
                is JassNullType,
                    -> JassCodeType()

                else -> JassUndefinedType()
            }

            else -> JassUndefinedType()
        }
    }
}
