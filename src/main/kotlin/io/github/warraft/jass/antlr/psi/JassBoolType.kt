package io.github.warraft.jass.antlr.psi

class JassBoolType : IJassType() {
    override val name: String = "boolean"

    override fun op(op: JassExprOp, b: IJassType): IJassType = when (op) {
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
