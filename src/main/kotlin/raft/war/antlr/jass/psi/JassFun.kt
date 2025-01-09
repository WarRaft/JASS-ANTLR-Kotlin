package raft.war.antlr.jass.psi

class JassFun(
    val name: String,
    val native: Boolean = false,
) : IJassNode, IJassStmtBlock {

    override var type: IJassType = JassUndefinedType()

    val param: MutableList<JassVar> = mutableListOf()
    val arg: MutableList<JassExpr> = mutableListOf()

    override val stmt: MutableList<IJassNode> = mutableListOf()

    override fun toString(): String = "JassFun(name='$name'):$type"
}
