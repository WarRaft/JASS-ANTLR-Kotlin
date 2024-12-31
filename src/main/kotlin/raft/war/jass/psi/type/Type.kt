package raft.war.jass.psi.type

import raft.war.jass.psi.Op

interface Type {
    val name: String
    fun op(op: Op, b: Type): Type
}
