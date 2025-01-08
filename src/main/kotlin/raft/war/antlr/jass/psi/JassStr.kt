package raft.war.antlr.jass.psi

class JassStr(val raw: String) : IJassNode {
    override val type: IJassType = JassStrType()

    override fun toString(): String = "<$type>$raw"
}
