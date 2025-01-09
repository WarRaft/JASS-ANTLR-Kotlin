package raft.war.antlr.jass.psi

class JassSet(
    val variable: JassVar,
    val expr: JassExpr,
) : IJassNode {
    override val type: IJassType? = variable.type
}
