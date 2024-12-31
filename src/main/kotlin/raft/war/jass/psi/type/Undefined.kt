package raft.war.jass.psi.type

import raft.war.jass.psi.Op

class Undefined : Type {
    override val name: String = "0undefined"

    override fun op(op: Op, b: Type): Type = Undefined()

    override fun toString(): String = name
}
