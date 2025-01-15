package raft.war.antlr.jass.psi

class JassIf(
    val expr: JassExpr? = null,
) : IJassNode {
    override var type: IJassType = JassUndefinedType()

    val stmt: MutableList<IJassNode> = mutableListOf()

    val elseifs: MutableList<JassIf> = mutableListOf()
    var elser: JassIf? = null

    override fun toString(): String = "if"
}
