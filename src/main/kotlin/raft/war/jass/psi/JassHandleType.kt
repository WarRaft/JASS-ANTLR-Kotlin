package raft.war.jass.psi

class JassHandleType(override val name: String) : IJassType {
    var parent: JassHandleType? = null

    override fun op(
        jassExprOp: JassExprOp,
        b: IJassType,
    ): IJassType {
        return JassUndefinedType()
    }

    override fun toString(): String = name
}
