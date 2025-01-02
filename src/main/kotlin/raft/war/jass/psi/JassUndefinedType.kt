package raft.war.jass.psi

class JassUndefinedType : IJassType {
    override val name: String = "0undefined"

    override fun op(jassExprOp: JassExprOp, b: IJassType): IJassType = JassUndefinedType()

    override fun toString(): String = "undefined"
}
