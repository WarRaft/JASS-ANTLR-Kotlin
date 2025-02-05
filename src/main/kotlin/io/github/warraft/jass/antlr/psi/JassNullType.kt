package io.github.warraft.jass.antlr.psi

import io.github.warraft.jass.antlr.psi.base.JassTypeBase

class JassNullType : JassTypeBase() {
    override val name: String = "null"

    override fun op(op: JassExprOp, b: JassTypeBase): JassTypeBase = when (op) {
        JassExprOp.Eq,
        JassExprOp.Neq,
            -> when (b) {
            is JassNullType, is JassIntType, is JassRealType, is JassStrType, is JassHandleType -> JassBoolType()
            else -> JassUndefinedType()
        }

        else -> JassUndefinedType()
    }

    override fun clone(): JassNullType = JassNullType()
}
