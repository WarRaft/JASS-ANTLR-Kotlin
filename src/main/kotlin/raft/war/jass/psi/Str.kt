package raft.war.jass.psi

import raft.war.jass.psi.type.Str
import raft.war.jass.psi.type.Type

class Str(val raw: String) : Node {
    override val type: Type = Str()

    override fun toString(): String = "<$type>$raw"
}
