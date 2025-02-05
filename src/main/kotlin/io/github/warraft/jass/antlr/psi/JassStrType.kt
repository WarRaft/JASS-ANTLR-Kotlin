package io.github.warraft.jass.antlr.psi

import io.github.warraft.jass.antlr.psi.base.JassTypeBase

class JassStrType : JassTypeBase() {
    override val name: String = "string"

    override fun op(op: JassExprOp, b: JassTypeBase): JassTypeBase = when (op) {
        JassExprOp.Set -> when (b) {
            is JassStrType, is JassNullType -> JassStrType()
            else -> JassUndefinedType()
        }

        JassExprOp.Add -> when (b) {
            is JassIntType, is JassRealType, is JassStrType -> JassStrType()
            else -> JassUndefinedType()
        }

        JassExprOp.Eq,
        JassExprOp.Neq,
            -> when (b) {
            is JassStrType, is JassNullType -> JassBoolType()
            else -> JassUndefinedType()
        }

        else -> JassUndefinedType()
    }

    override fun clone(): JassStrType = JassStrType()
}
