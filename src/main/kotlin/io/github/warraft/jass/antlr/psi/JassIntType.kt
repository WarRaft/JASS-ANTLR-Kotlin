package io.github.warraft.jass.antlr.psi

class JassIntType() : IJassType() {
    override val name: String = "integer"
    override fun op(op: JassExprOp, b: IJassType): IJassType {
        return when (op) {
            JassExprOp.Add -> when (b) {
                is JassIntType -> JassIntType()
                is JassRealType -> JassRealType()
                is JassStrType -> JassStrType()
                else -> JassUndefinedType()
            }

            JassExprOp.Sub, JassExprOp.Mul, JassExprOp.Div -> when (b) {
                is JassIntType -> JassIntType()
                is JassRealType -> JassRealType()
                else -> JassUndefinedType()
            }

            JassExprOp.Set -> when (b) {
                is JassIntType -> JassIntType()
                else -> JassUndefinedType()
            }

            JassExprOp.Eq,
            JassExprOp.Neq,
                -> when (b) {
                is JassIntType, is JassNullType -> JassBoolType()
                else -> JassUndefinedType()
            }

            else -> JassUndefinedType()
        }
    }
}
