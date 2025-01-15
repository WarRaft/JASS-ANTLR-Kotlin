package raft.war.antlr.jass.psi

class JassVar(
    var name: String,
    val constant: Boolean = false,
    val global: Boolean = false,
    val array: Boolean = false,
    val local: Boolean = false,
    val param: Boolean = false,
    var base: JassVar? = null,
    var index: JassExpr? = null,
    var expr: JassExpr? = null,
    override val type: IJassType,
) : IJassNode {

    val basename: String
        get() = base?.basename ?: name

    fun clone(
        index: JassExpr? = null,
        expr: JassExpr? = null,
    ): JassVar = JassVar(
        name = name,
        constant = constant,
        global = global,
        array = array,
        local = local,
        param = param,
        type = type,
        base = this,
        expr = expr ?: this.expr,
        index = index ?: this.index
    )

    override fun toString(): String {
        val list: MutableList<String> = mutableListOf()

        if (global) {
            if (constant) list.add("constant")
            list.add("global")
        }

        if (local) list.add("local")
        if (param) list.add("param")
        list.add(type.name)

        if (array) list.add("[]")

        list.add(name)

        if (expr != null) {
            list.add("=")
            list.add(expr!!.toString())
        }

        return return list.joinToString(" ")
    }
}
