package raft.war.antlr.jass.psi

class JassExpr(
    val op: JassExprOp,
    val a: IJassNode,
    val b: IJassNode? = null,
) : IJassNode {
    override var type: IJassType = if (b == null) {
        a.type ?: JassUndefinedType()
    } else {
        a.type?.op(op, b.type ?: JassUndefinedType()) ?: JassUndefinedType()
    }

    override fun toString(): String {
        return when (op) {
            JassExprOp.Get -> "$a"
            else -> return "$op<$type>($a, $b)"
        }
    }
}
