package raft.war.jass.psi

import raft.war.jass.psi.type.Type

class Variable(
    val name: String,
    val constant: Boolean = false,
    val global: Boolean = false,
    val array: Boolean = false,
    val local: Boolean = false,
    val param: Boolean = false,
    override val type: Type? = null,
) : Node {

    var expr: Expr? = null

    override fun toString(): String {
        val list: MutableList<String> = mutableListOf()

        if (global) {
            if (constant) list.add("constant")
            list.add("global")
        }

        if (local) list.add("local")
        if (param) list.add("param")
        if (type != null) list.add(type.name)

        if (array) list.add("[]")

        list.add(name)

        if (expr != null) {
            list.add("=")
            list.add(expr!!.toString())
        }

        return return list.joinToString(" ")
    }
}
