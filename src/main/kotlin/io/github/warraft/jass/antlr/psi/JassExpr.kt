package io.github.warraft.jass.antlr.psi

class JassExpr(
    val op: JassExprOp,
    val a: IJassNode?,
    val b: IJassNode? = null,
) : IJassNode() {
    override var type: IJassType

    init {
        type = JassUndefinedType()
        if (a != null) {
            type = a.type!!
        }
        if (a != null && b != null) {
            type = a.type?.op(op, b.type!!) ?: JassUndefinedType()
        }
    }

    override fun toString(): String {
        return when (op) {
            JassExprOp.Get -> "$a"
            else -> return "$type:$op($a, $b)"
        }
    }
}
