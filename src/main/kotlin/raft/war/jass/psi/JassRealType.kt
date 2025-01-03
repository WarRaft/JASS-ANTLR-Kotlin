package raft.war.jass.psi

class JassRealType : IJassType {
    override val name: String = "real"

    override fun toString(): String = name

    override fun op(jassExprOp: JassExprOp, b: IJassType): IJassType {
        return when (jassExprOp) {
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
}
