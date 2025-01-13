package raft.war.antlr.lua

import raft.war.antlr.jass.JassState
import raft.war.antlr.jass.psi.*
import raft.war.antlr.jass.psi.JassExprOp.*
import java.io.File
import java.nio.file.Path
import kotlin.io.path.absolute

class JassLua(val jass: JassState, val output: Path) {
    val builder = StringBuilder()

    fun tab(c: Int): StringBuilder {
        (0..c).forEach { builder.append("\t") }
        return builder
    }

    fun reserved(name: String): Boolean = when (name) {
        "break", "end", "for", "in", "nil", "repeat", "until", "while", "do" -> true
        else -> false
    }

    fun expr(op: JassExprOp, a: IJassNode, b: IJassNode) {
        val s = when (op) {
            Mul -> "*"
            Div -> "/"
            Add -> {
                if (a.type is JassStrType || b.type is JassStrType) ".."
                else "+"
            }

            Sub -> "-"
            Lt -> "<"
            LtEq -> "<="
            Gt -> ">"
            GtEq -> ">="

            Eq -> "=="
            Neq -> "~="

            And -> "and"
            Or -> "or"

            else -> {
                println("⚠️Lua: Missing $op")
                "$op"
            }
        }
        expr(a)
        builder.append(" $s ")
        expr(b)
    }

    fun expr(e: IJassNode?) {
        if (e == null) return
        when (e) {
            is JassNull -> builder.append("nil")
            is JassBool -> builder.append(e.raw)
            is JassInt -> builder.append(e.raw)
            is JassReal -> builder.append(e.raw)
            is JassStr -> builder.append(e.raw)
            is JassVar -> {
                builder.append(e.name)
                if (e.array) {
                    builder.append("[")
                    expr(e.expr)
                    builder.append("]")
                }
            }

            is JassExpr -> when (e.op) {
                Get -> expr(e.a)
                Set -> {
                    println("🍒Lua: expr Set!!!")
                }

                Add, Sub,
                Mul, Div,
                Lt, LtEq, Gt, GtEq,
                Eq, Neq,
                And, Or,
                    -> if (e.a != null && e.b != null)
                    expr(e.op, e.a, e.b)

                Paren -> {
                    builder.append("(")
                    expr(e.a)
                    builder.append(")")
                }

                UnSub -> {
                    builder.append("-")
                    expr(e.a)
                }

                UnNot -> {
                    builder.append("not ")
                    expr(e.a)
                }

            }

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

    fun stmt(nodes: List<IJassNode>, level: Int) {
        for (node in nodes) {
            if (node is JassSet) {
                tab(level)
                    .append(node.variable.name)
                    .append(" = ")

                expr(node.expr)
            }

            if (node is JassLoop) {
                tab(level).append("while(true) do\n")

                stmt(node.stmt, level + 1)

                tab(level).append("end")
            }

            if (node is JassExitWhen) {
                tab(level).append("if (")
                expr(node.expr)
                builder.append(") then break end\n")
            }

            if (node is JassReturn) {
                tab(level).append("return")
                if (node.expr != null) {
                    builder.append(" ")
                    expr(node.expr)
                }
                builder.append("\n")
            }

            builder.append("\n")
        }
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

        stmt(f.stmt, 0)

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
