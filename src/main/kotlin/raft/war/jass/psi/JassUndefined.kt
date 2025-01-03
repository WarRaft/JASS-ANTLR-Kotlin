package raft.war.jass.psi

class JassUndefined(val raw: String) : IJassNode {

    override val type: IJassType = JassUndefinedType()

    override fun toString(): String = "<$type>$raw"
}
