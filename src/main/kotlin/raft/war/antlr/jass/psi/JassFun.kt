package raft.war.antlr.jass.psi

class JassFun(
    val name: String,
    val native: Boolean = false,
    val ref: Boolean = false,
    override var type: IJassType = JassUndefinedType(),
) : IJassNode, IJassStmtBlock {

    var base: JassFun? = null

    val basename: String
        get() = base?.basename ?: name

    val param: MutableList<JassVar> = mutableListOf()
    val arg: MutableList<JassExpr> = mutableListOf()

    override val stmt: MutableList<IJassNode> = mutableListOf()

    override fun toString(): String = "JassFun(name='$name'):$type"
}
