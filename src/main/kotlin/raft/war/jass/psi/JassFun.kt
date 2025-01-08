package raft.war.jass.psi

class JassFun(
    val name: String,
    val native: Boolean = false,
) : IJassNode {
    override var type: IJassType = JassUndefinedType()

    val param: MutableList<JassVar> = mutableListOf()
    val arg: MutableList<JassExpr> = mutableListOf()

    override fun toString(): String = "JassFun(name='$name'):$type"
}
