package raft.war.jass.psi

interface IJassType {
    val name: String
    fun op(op: JassExprOp, b: IJassType): IJassType
}
