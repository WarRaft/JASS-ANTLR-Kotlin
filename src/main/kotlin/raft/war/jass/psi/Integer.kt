package raft.war.jass.psi

import raft.war.jass.psi.type.Type
import raft.war.jass.psi.type.Integer

class Integer(val raw: String) : Node {
    override val type: Type = Integer()

    override fun toString(): String = "<$type>$raw"
}
