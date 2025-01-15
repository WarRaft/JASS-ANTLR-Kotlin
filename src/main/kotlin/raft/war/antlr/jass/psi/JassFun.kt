package raft.war.antlr.jass.psi

class JassFun(
    val name: String,
    val native: Boolean = false,
    val call: Boolean = false,
    val ref: Boolean = false,
    var base: JassFun? = null,
    override var type: IJassType = JassUndefinedType(),
) : IJassNode {

    val basename: String
        get() = base?.basename ?: name

    val param: MutableList<JassVar> = mutableListOf()
    val arg: MutableList<JassExpr> = mutableListOf()

    val stmt: MutableList<IJassNode> = mutableListOf()

    override fun toString(): String = "JassFun(name='$name'):$type"
}
