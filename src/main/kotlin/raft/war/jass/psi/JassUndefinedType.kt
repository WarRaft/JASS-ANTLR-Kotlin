package raft.war.jass.psi

class JassUndefinedType : IJassType {
    override val name: String = "undefined"

    override fun op(op: JassExprOp, b: IJassType): IJassType = JassUndefinedType()

    override fun toString(): String = name
}
