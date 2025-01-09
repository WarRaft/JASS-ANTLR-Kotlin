package raft.war.antlr.jass.psi

class JassLoop : IJassNode, IJassStmtBlock {
    override var type: IJassType = JassUndefinedType()

    override val stmt: MutableList<IJassNode> = mutableListOf()

    override fun toString(): String = "loop"
}
