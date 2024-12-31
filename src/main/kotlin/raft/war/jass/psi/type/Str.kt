package raft.war.jass.psi.type

import raft.war.jass.psi.Op

class Str : Type {
    override val name: String = "string"

    override fun op(op: Op, b: Type): Type {
        return when (op) {
            Op.Add -> when (b) {
                is Integer, is Real, is Str -> Str()
                else -> Undefined()
            }

            else -> Undefined()
        }
    }

    override fun toString(): String = name
}
