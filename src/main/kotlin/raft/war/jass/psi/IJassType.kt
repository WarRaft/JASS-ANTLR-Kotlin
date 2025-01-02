package raft.war.jass.psi

interface IJassType {
    val name: String
    fun op(jassExprOp: JassExprOp, b: IJassType): IJassType
}
