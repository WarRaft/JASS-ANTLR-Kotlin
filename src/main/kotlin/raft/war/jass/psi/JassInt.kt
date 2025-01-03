package raft.war.jass.psi

class JassInt(val raw: String) : IJassNode {
    override val type: IJassType = JassIntType()

    override fun toString(): String = "<$type>$raw"
}
