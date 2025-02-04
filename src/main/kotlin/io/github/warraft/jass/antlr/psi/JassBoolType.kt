package io.github.warraft.jass.antlr.psi

import io.github.warraft.jass.antlr.psi.base.JassTypeBase

class JassBoolType : JassTypeBase() {
    override val name: String = "boolean"

    override fun op(op: JassExprOp, b: JassTypeBase): JassTypeBase = when (op) {
        JassExprOp.Set -> when (b) {
            is JassBoolType -> JassBoolType()
            else -> JassUndefinedType()
        }

        JassExprOp.And, JassExprOp.Or -> when (b) {
            is JassBoolType -> JassBoolType()
            else -> JassUndefinedType()
        }

        JassExprOp.Eq, JassExprOp.Neq -> when (b) {
            is JassBoolType, is JassNullType -> JassBoolType()
            else -> JassUndefinedType()
        }

        else -> JassUndefinedType()
    }
}
