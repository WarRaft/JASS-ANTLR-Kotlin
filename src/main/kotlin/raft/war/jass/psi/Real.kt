package raft.war.jass.psi

import raft.war.jass.psi.type.Type
import raft.war.jass.psi.type.Real

class Real(val raw: String) : Node {
    override val type: Type = Real()

    override fun toString(): String = "<$type>$raw"
}
