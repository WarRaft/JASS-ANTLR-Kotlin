package raft.war.antlr.jass.psi

class JassRealType : IJassType {
    override val name: String = "real"

    override fun op(op: JassExprOp, b: IJassType): IJassType {
        return when (op) {
            JassExprOp.Add -> when (b) {
                is JassIntType, is JassRealType -> JassRealType()
                is JassStrType -> JassStrType()
                else -> JassUndefinedType()
            }

            JassExprOp.Sub, JassExprOp.Mul, JassExprOp.Div -> when (b) {
                is JassIntType, is JassRealType -> JassRealType()
                else -> JassUndefinedType()
            }

            JassExprOp.Set -> when (b) {
                is JassIntType, is JassRealType -> JassRealType()
                else -> JassUndefinedType()
            }

            else -> JassUndefinedType()
        }
    }

    override fun toString(): String = "<primitive>$name"
}
