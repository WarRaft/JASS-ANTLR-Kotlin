package raft.war.jass.psi.type

import raft.war.jass.psi.Op

class Integer() : Type {
    override val name: String = "integer"
    override fun op(op: Op, b: Type): Type {
        return when (op) {
            Op.Add -> when (b) {
                is Integer -> Integer()
                is Real -> Real()
                is Str -> Str()
                else -> Undefined()
            }

            Op.Sub, Op.Mul, Op.Div -> when (b) {
                is Integer -> Integer()
                is Real -> Real()
                else -> Undefined()
            }

            else -> Undefined()
        }
    }

    override fun toString(): String = name
}
