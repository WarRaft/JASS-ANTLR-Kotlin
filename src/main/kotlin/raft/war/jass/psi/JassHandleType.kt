package raft.war.jass.psi

class JassHandleType(override val name: String) : IJassType {
    var parent: JassHandleType? = null

    override fun op(
        op: JassExprOp,
        b: IJassType,
    ): IJassType {
        return when (op) {
            JassExprOp.Set -> when (b) {
                is JassHandleType -> {
                    if (name == b.name) this
                    else JassUndefinedType()
                }

                else -> JassUndefinedType()
            }

            else -> JassUndefinedType()
        }
    }

    override fun toString(): String = "<handle>$name"
}
