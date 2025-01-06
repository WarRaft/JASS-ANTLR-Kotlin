package raft.war.jass.psi

class JassCodeType() : IJassType {
    override val name: String = "code"
    override fun op(op: JassExprOp, b: IJassType): IJassType {
        return when (op) {
            JassExprOp.Set -> when (b) {
                is JassCodeType -> JassCodeType()
                else -> JassUndefinedType()
            }

            else -> JassUndefinedType()
        }
    }

    override fun toString(): String = name
}
