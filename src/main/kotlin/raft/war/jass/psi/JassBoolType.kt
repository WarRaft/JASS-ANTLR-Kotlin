package raft.war.jass.psi

class JassBoolType : IJassType {
    override val name: String = "bool"

    override fun op(jassExprOp: JassExprOp, b: IJassType): IJassType {
        return when (jassExprOp) {
            JassExprOp.Set -> when (b) {
                is JassBoolType -> JassBoolType()
                else -> JassUndefinedType()
            }

            else -> JassUndefinedType()
        }
    }

    override fun toString(): String = name
}
