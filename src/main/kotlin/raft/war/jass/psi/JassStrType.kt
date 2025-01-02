package raft.war.jass.psi

class JassStrType : IJassType {
    override val name: String = "string"

    override fun op(jassExprOp: JassExprOp, b: IJassType): IJassType {
        return when (jassExprOp) {
            JassExprOp.Set -> when (b) {
                is JassStrType -> JassStrType()
                else -> JassUndefinedType()
            }

            JassExprOp.Add -> when (b) {
                is JassIntType, is JassRealType, is JassStrType -> JassStrType()
                else -> JassUndefinedType()
            }

            else -> JassUndefinedType()
        }
    }

    override fun toString(): String = name
}
