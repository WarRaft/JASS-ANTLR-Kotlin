package io.github.warraft.jass.antlr.psi

import io.github.warraft.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.jass.antlr.psi.base.JassTypeBase

class JassExpr(
    val op: JassExprOp,
    val a: JassNodeBase?,
    val b: JassNodeBase? = null,
) : JassNodeBase() {
    override var type: JassTypeBase

    init {
        type = JassUndefinedType()
        if (a?.type != null) {
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
