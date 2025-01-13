package raft.war.antlr.jass.psi

class JassNull : IJassNode {
    override val type: IJassType = JassNullType()

    override fun toString(): String = "$type"
}
