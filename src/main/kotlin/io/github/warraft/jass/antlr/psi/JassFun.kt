package io.github.warraft.jass.antlr.psi

class JassFun(
    val name: String,
    val native: Boolean = false,
    val call: Boolean = false,
    val ref: Boolean = false,
    var base: JassFun? = null,
    override var type: IJassType = JassUndefinedType(),
) : IJassNode {

    var fakename: String = ""

    val root: JassFun
        get() = base ?: this

    val param: MutableList<JassVar> = mutableListOf()
    val arg: MutableList<JassExpr> = mutableListOf()

    val stmt: MutableList<IJassNode> = mutableListOf()

    fun clone(): JassFun = JassFun(
        name = name,
        native = native,
        call = call,
        ref = ref,
        base = this,
        type = type,
    )

    override fun toString(): String = "JassFun(name='$name'):$type"
}
