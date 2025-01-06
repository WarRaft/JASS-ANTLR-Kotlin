package raft.war.lua

import raft.war.jass.JassState
import raft.war.jass.psi.IJassNode
import raft.war.jass.psi.IJassType
import raft.war.jass.psi.JassBool
import raft.war.jass.psi.JassBoolType
import raft.war.jass.psi.JassExpr
import raft.war.jass.psi.JassExprOp
import raft.war.jass.psi.JassFun
import raft.war.jass.psi.JassHandleType
import raft.war.jass.psi.JassInt
import raft.war.jass.psi.JassIntType
import raft.war.jass.psi.JassReal
import raft.war.jass.psi.JassRealType
import raft.war.jass.psi.JassStr
import raft.war.jass.psi.JassStrType
import raft.war.jass.psi.JassUndefinedType
import raft.war.jass.psi.JassVar
import java.io.File
import java.nio.file.Path
import kotlin.io.path.absolute

class JassLua(val jass: JassState, val output: Path) {
    val builder = StringBuilder()

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
            is JassFun -> {
                builder.append("${e.name}(")
                e.args.forEachIndexed { index, arg ->
                    if (index > 0) builder.append(", ")
                    expr(arg)
                }
                builder.append(")")
            }

            else -> null
        }
    }

    fun typeName(type: IJassType, array: Boolean = false): String {
        val a = if (array) "[]" else ""
        return when (type) {
            is JassBoolType -> "boolean$a"
            is JassIntType -> "number$a integer"
            is JassRealType -> "number$a real"
            else -> type.name
        }
    }

    fun variable(v: JassVar) {
        builder.append("\n")
        if (v.constant) builder.append("--- constant\n")

        builder
            .append("---@type ")
            .append(typeName(v.type, v.array))
            .append("\n")

        if (v.local) builder.append("local ")
        builder.append(v.name).append(" = ")
        if (v.expr == null) builder.append(if (v.array) "{}" else "nil")
        else expr(v.expr!!)

        builder.append("\n")
    }

    fun function(f: JassFun) {
        builder.append("\n")
        if (f.native) builder.append("--- native\n")
        f.params.forEach {
            if (!it.param) return
            builder.append("---@param ${it.name} ${typeName(it.type)}\n")
        }

        if (f.type !is JassUndefinedType) {
            builder.append("---@return ${typeName(f.type)}\n")
        }

        builder.append("function ${f.name} (")
        val list: MutableList<String> = mutableListOf()
        f.params.forEach {
            if (!it.param) return
            list.add(it.name)
        }

        builder.append(list.joinToString(", "))
        builder.append(")")

        builder.append(" end")

        builder.append("\n")
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

        jass.natives.forEach(::function)

        jass.globals.forEach(::variable)
        builder.append("\n")

        File(output.absolute().toString()).writeText(builder.toString())
    }
}
