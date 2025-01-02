package raft.war.jass.psi

class JassReal(val raw: String) : IJassNode {
    override val type: IJassType = JassRealType()

    override fun toString(): String = "<$type>$raw"
}
