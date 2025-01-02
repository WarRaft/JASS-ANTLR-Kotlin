package raft.war.lua

import raft.war.jass.JassState
import raft.war.jass.psi.IJassNode
import raft.war.jass.psi.IJassType
import raft.war.jass.psi.JassBool
import raft.war.jass.psi.JassBoolType
import raft.war.jass.psi.JassExpr
import raft.war.jass.psi.JassExprOp
import raft.war.jass.psi.JassHandleType
import raft.war.jass.psi.JassInt
import raft.war.jass.psi.JassIntType
import raft.war.jass.psi.JassReal
import raft.war.jass.psi.JassRealType
import raft.war.jass.psi.JassStr
import raft.war.jass.psi.JassStrType
import raft.war.jass.psi.JassVar
import java.io.File
import java.nio.file.Path
import kotlin.io.path.absolute

class JassLua(val jass: JassState, val output: Path) {
    val builder = StringBuilder()

    fun annotateType(t: IJassType, array: Boolean) {
        val a = if (array) "[]" else ""

        builder
            .append("---@type ")
            .append(
                when (t) {
                    is JassBoolType -> "boolean$a"
                    is JassIntType -> "number$a integer"
                    is JassRealType -> "number$a real"
                    else -> t.name
                }
            )
            .append("\n")
    }


    fun expr(op: JassExprOp, a: IJassNode, b: IJassNode) {
        val s = when (op) {
            JassExprOp.Mul -> "*"
            JassExprOp.Div -> "/"
            JassExprOp.Add -> {
                if (a.type is JassStrType || b.type is JassStrType) ".."
                else "+"
            }

            JassExprOp.Sub -> "-"
            else -> "$op"
        }
        expr(a)
        builder.append(" $s ")
        expr(b)
    }

    fun expr(e: IJassNode) {
        when (e) {
            is JassExpr -> when (e.op) {
                JassExprOp.Get -> expr(e.a)
                JassExprOp.Set -> builder.append("!!!")
                JassExprOp.Add,
                JassExprOp.Sub,
                JassExprOp.Mul,
                JassExprOp.Div,
                    -> expr(e.op, e.a, e.b!!)
            }

            is JassBool -> builder.append(e.raw)
            is JassInt -> builder.append(e.raw)
            is JassReal -> builder.append(e.raw)
            is JassStr -> builder.append(e.raw)
            //is JassExpr -> builder.append(e.a)
            else -> null
        }
    }

    fun variable(v: JassVar) {
        if (v.constant) builder.append("--- constant\n")

        annotateType(v.type, v.array)

        if (v.local) builder.append("local ")
        builder.append(v.name).append(" = ")
        if (v.expr == null) builder.append(if (v.array) "{}" else "nil")
        else expr(v.expr!!)

        builder.append("\n\n")
    }

    fun type(t: JassHandleType) {
        builder.append("---@class ${t.name}")

        if (t.parent != null) builder
            .append(":")
            .append(t.parent!!.name)
        builder.append("\n")
    }

    fun convert() {
        builder.clear()

        jass.types.forEach(::type)
        builder.append("\n")
        jass.globals.forEach(::variable)

        File(output.absolute().toString()).writeText(builder.toString())
    }
}
