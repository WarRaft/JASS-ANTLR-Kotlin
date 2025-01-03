package raft.war.jass.psi

class JassBool(val raw: String) : IJassNode {
    override val type: IJassType = JassBoolType()

    override fun toString(): String = "<$type>$raw"
}
