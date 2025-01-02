package raft.war.jass.psi

class JassIntType() : IJassType {
    override val name: String = "integer"
    override fun op(jassExprOp: JassExprOp, b: IJassType): IJassType {
        return when (jassExprOp) {
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

            else -> JassUndefinedType()
        }
    }

    override fun toString(): String = name
}
