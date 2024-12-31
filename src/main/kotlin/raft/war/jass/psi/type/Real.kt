package raft.war.jass.psi.type

import raft.war.jass.psi.Op

class Real : Type {
    override val name: String = "real"

    override fun toString(): String = name

    override fun op(op: Op, b: Type): Type {
        return when (op) {
            Op.Add -> when (b) {
                is Integer, is Real -> Real()
                is Str -> Str()
                else -> Undefined()
            }

            Op.Sub, Op.Mul, Op.Div -> when (b) {
                is Integer, is Real -> Real()
                else -> Undefined()
            }

            else -> Undefined()
        }
    }
}
