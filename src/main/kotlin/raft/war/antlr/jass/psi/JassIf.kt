package raft.war.antlr.jass.psi

enum class JassIfMode {
    If, ElseIF, Else
}

class JassIf(
    val expr: JassExpr?,
    val mode: JassIfMode,
) : IJassNode, IJassStmtBlock {
    override var type: IJassType = JassUndefinedType()

    override val stmt: MutableList<IJassNode> = mutableListOf()

    override fun toString(): String = "if"

    val elseifs: MutableList<IJassNode> = mutableListOf()
    val elses: MutableList<IJassNode> = mutableListOf()
}
