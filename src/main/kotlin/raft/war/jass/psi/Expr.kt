package raft.war.jass.psi

import raft.war.jass.psi.type.Type
import raft.war.jass.psi.type.Undefined

class Expr(
    val op: Op,
    val a: Node,
    val b: Node? = null,
) : Node {
    override var type: Type = if (b == null) {
        a.type ?: Undefined()
    } else {
        a.type?.op(op, b.type ?: Undefined()) ?: Undefined()
    }

    override fun toString(): String {
        return when (op) {
            Op.Get -> "$a"
            else -> return "$op<$type>($a, $b)"
        }
    }
}
