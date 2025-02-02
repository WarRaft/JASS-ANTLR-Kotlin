package io.github.warraft.jass.antlr.psi

class JassIntType() : IJassType() {
    override val name: String = "integer"
    override fun op(op: JassExprOp, b: IJassType): IJassType {
        return when (op) {
            JassExprOp.Set -> when (b) {
                is JassIntType -> JassIntType()
                else -> JassUndefinedType()
            }

            JassExprOp.Add -> when (b) {
                is JassIntType -> JassIntType()
                is JassRealType -> JassRealType()
                else -> JassUndefinedType()
            }

            JassExprOp.Sub, JassExprOp.Mul, JassExprOp.Div -> when (b) {
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

            else -> JassUndefinedType()
        }
    }
}
