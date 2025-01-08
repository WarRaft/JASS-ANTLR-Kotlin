package raft.war.antlr.lua

import raft.war.antlr.jass.JassState
import raft.war.antlr.jass.psi.IJassNode
import raft.war.antlr.jass.psi.IJassType
import raft.war.antlr.jass.psi.JassBool
import raft.war.antlr.jass.psi.JassBoolType
import raft.war.antlr.jass.psi.JassCodeType
import raft.war.antlr.jass.psi.JassExpr
import raft.war.antlr.jass.psi.JassExprOp
import raft.war.antlr.jass.psi.JassFun
import raft.war.antlr.jass.psi.JassHandleType
import raft.war.antlr.jass.psi.JassInt
import raft.war.antlr.jass.psi.JassIntType
import raft.war.antlr.jass.psi.JassReal
import raft.war.antlr.jass.psi.JassRealType
import raft.war.antlr.jass.psi.JassStr
import raft.war.antlr.jass.psi.JassStrType
import raft.war.antlr.jass.psi.JassUndefinedType
import raft.war.antlr.jass.psi.JassVar
import java.io.File
import java.nio.file.Path
import kotlin.io.path.absolute

class JassLua(val jass: JassState, val output: Path) {
    val builder = StringBuilder()

    fun reserved(name: String): Boolean = when (name) {
        "break", "end", "for", "in", "nil", "repeat", "until", "while", "do" -> true
        else -> false
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
            is JassVar -> builder.append(e.name)
            is JassFun -> {
                builder.append("${e.name}(")
                e.arg.forEachIndexed { index, arg ->
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
            is JassCodeType -> "function"
            else -> type.name
        }
    }

    fun variable(v: JassVar) {
        if (v.local) builder.append("local ")
        builder.append(v.name).append(" = ")
        if (v.expr == null) builder.append(if (v.array) "{}" else "nil")
        else expr(v.expr!!)

        builder
            .append(" ---@type ")
            .append(typeName(v.type, v.array))

        if (v.constant) builder.append(" constant")

        builder.append("\n")
    }

    fun function(f: JassFun) {
        builder.append("\n")
        if (f.native) builder.append("--- native\n")
        f.param.forEach {
            if (reserved(it.name)) {
                it.name += "_"
            }
            if (it.param) {
                builder.append("---@param ${it.name} ${typeName(it.type)}\n")
            }
        }

        if (f.type !is JassUndefinedType) {
            builder.append("---@return ${typeName(f.type)}\n")
        }

        builder.append("function ${f.name} (")
        val list: MutableList<String> = mutableListOf()
        for (it in f.param) {
            if (!it.param) break
            list.add(it.name)
        }

        builder.append(list.joinToString(", "))
        builder.append(")\n")

        for (it in f.param) {
            if (it.param) continue
            if (reserved(it.name)) {
                it.name += "_"
            }

            builder.append("\tlocal ${it.name}")

            if (it.expr != null) {
                builder.append(" = ")
                expr(it.expr!!)
            }

            builder
                .append(" ---@type ")
                .append(typeName(it.type))
                .append("\n")
        }

        builder.append("end")

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

        builder.append("\n")

        jass.globals.forEach(::variable)

        builder.append("\n")

        jass.functions.forEach(::function)

        File(output.absolute().toString()).writeText(builder.toString().trim())
    }
}
