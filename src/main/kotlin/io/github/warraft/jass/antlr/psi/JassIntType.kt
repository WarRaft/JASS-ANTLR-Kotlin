package io.github.warraft.jass.antlr.psi

import io.github.warraft.jass.antlr.psi.base.JassTypeBase

class JassIntType() : JassTypeBase() {
    override val name: String = "integer"
    override fun op(op: JassExprOp, b: JassTypeBase): JassTypeBase {
        return when (op) {
            JassExprOp.Add, JassExprOp.Sub, JassExprOp.Mul, JassExprOp.Div -> when (b) {
                is JassIntType -> JassIntType()
                is JassRealType -> JassRealType()
                else -> JassUndefinedType()
            }

            JassExprOp.Lt, JassExprOp.LtEq, JassExprOp.Gt, JassExprOp.GtEq -> when (b) {
                is JassIntType, is JassRealType -> JassBoolType()
                else -> JassUndefinedType()
            }

            JassExprOp.Eq, JassExprOp.Neq -> when (b) {
                is JassIntType, is JassRealType, is JassNullType -> JassBoolType()
                else -> JassUndefinedType()
            }

            JassExprOp.Set -> when (b) {
                is JassIntType -> JassIntType()
                else -> JassUndefinedType()
            }

            else -> JassUndefinedType()
        }
    }
}
