package raft.war.jass.psi

class JassCall() : IJassNode {
    val raw: String = ""

    override val type: IJassType = JassUndefinedType()

    override fun toString(): String = "call<$type>"
}