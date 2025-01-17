@file:Suppress("DuplicatedCode")

package raft.war.antlr.jass.converter

import raft.war.antlr.jass.JassState
import raft.war.antlr.jass.psi.IJassNode
import raft.war.antlr.jass.psi.IJassType
import raft.war.antlr.jass.psi.JassBool
import raft.war.antlr.jass.psi.JassBoolType
import raft.war.antlr.jass.psi.JassCodeType
import raft.war.antlr.jass.psi.JassExitWhen
import raft.war.antlr.jass.psi.JassExpr
import raft.war.antlr.jass.psi.JassExprOp
import raft.war.antlr.jass.psi.JassFun
import raft.war.antlr.jass.psi.JassHandleType
import raft.war.antlr.jass.psi.JassIf
import raft.war.antlr.jass.psi.JassInt
import raft.war.antlr.jass.psi.JassIntType
import raft.war.antlr.jass.psi.JassLoop
import raft.war.antlr.jass.psi.JassNull
import raft.war.antlr.jass.psi.JassReal
import raft.war.antlr.jass.psi.JassRealType
import raft.war.antlr.jass.psi.JassReturn
import raft.war.antlr.jass.psi.JassStr
import raft.war.antlr.jass.psi.JassStrType
import raft.war.antlr.jass.psi.JassUndefinedType
import raft.war.antlr.jass.psi.JassVar
import java.io.File
import java.nio.file.Path
import kotlin.io.path.absolute

class JassLua(val jass: JassState, val output: Path) {
    val builder = StringBuilder()

    fun tab(c: Int): StringBuilder {
        (0..c).forEach { builder.append("\t") }
        return builder
    }

    fun varname(v: JassVar): StringBuilder {
        val root = v.root
        builder.append(root.name)
        return builder
    }

    fun funname(f: JassFun): StringBuilder {
        val root = f.root
        builder.append(root.name)
        return builder
    }

    fun reserved(name: String): Boolean = when (name) {
        "and", "break", "do", "else", "elseif", "end", "false", "for", "function", "if", "in", "local", "nil", "not", "or", "repeat", "return", "then", "true", "until", "while" -> true
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
            JassExprOp.Lt -> "<"
            JassExprOp.LtEq -> "<="
            JassExprOp.Gt -> ">"
            JassExprOp.GtEq -> ">="

            JassExprOp.Eq -> "=="
            JassExprOp.Neq -> "~="

            JassExprOp.And -> "and"
            JassExprOp.Or -> "or"

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
            is JassInt -> {
                if (e.raw.startsWith("'")) {
                    builder
                        .append("FourCC(")
                        .append(e.raw)
                        .append(")")
                } else {
                    builder.append(e.raw)
                }

            }

            is JassReal -> builder.append(e.raw)
            is JassStr -> builder.append(e.raw)
            is JassVar -> {
                varname(e)
                if (e.index != null) {
                    builder.append("[")
                    expr(e.index)
                    builder.append("]")
                }
            }

            is JassExpr -> when (e.op) {
                JassExprOp.Get -> expr(e.a)
                JassExprOp.Set -> {
                    println("🍒Lua: expr Set!!!")
                }

                JassExprOp.Add, JassExprOp.Sub,
                JassExprOp.Mul, JassExprOp.Div,
                JassExprOp.Lt, JassExprOp.LtEq, JassExprOp.Gt, JassExprOp.GtEq,
                JassExprOp.Eq, JassExprOp.Neq,
                JassExprOp.And, JassExprOp.Or,
                    -> if (e.a != null && e.b != null)
                    expr(e.op, e.a, e.b)

                JassExprOp.Paren -> {
                    builder.append("(")
                    expr(e.a)
                    builder.append(")")
                }

                JassExprOp.UnSub -> {
                    builder.append("-")
                    expr(e.a)
                }

                JassExprOp.UnNot -> {
                    builder.append("not ")
                    expr(e.a)
                }

            }

            is JassFun -> {
                funname(e)
                if (!e.ref) {
                    builder.append("(")
                    e.arg.forEachIndexed { index, arg ->
                        if (index > 0) builder.append(", ")
                        expr(arg)
                    }
                    builder.append(")")
                }
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

    fun global(v: JassVar) {
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

            when (node) {
                is JassIf -> {
                    tab(level).append("if ")
                    expr(node.expr)
                    builder.append(" then\n")

                    stmt(node.stmt, level + 1)

                    for (eif in node.elseifs) {
                        tab(level).append("elseif ")
                        expr(eif.expr)
                        builder.append(" then\n")
                        stmt(eif.stmt, level + 1)
                    }

                    val elser = node.elser
                    if (elser != null) {
                        tab(level).append("else\n")
                        stmt(elser.stmt, level + 1)
                    }

                    tab(level).append("end")
                }

                is JassVar -> {
                    tab(level)
                    varname(node)

                    if (node.index != null) {
                        builder.append("[")
                        expr(node.index)
                        builder.append("]")
                    }
                    builder.append(" = ")
                    expr(node.expr)
                }

                is JassFun -> {
                    if (!node.call) continue
                    tab(level)
                    funname(node)

                    builder.append("(")
                    node.arg.forEachIndexed { index, arg ->
                        if (index > 0) builder.append(", ")
                        expr(arg)
                    }
                    builder.append(")")
                }

                is JassLoop -> {
                    tab(level).append("while(true) do\n")

                    stmt(node.stmt, level + 1)

                    tab(level).append("end")
                }

                is JassExitWhen -> {
                    tab(level).append("if (")
                    expr(node.expr)
                    builder.append(") then break end")
                }

                is JassReturn -> {
                    tab(level).append("return")
                    if (node.expr != null) {
                        builder.append(" ")
                        expr(node.expr)
                    }
                }

                else -> println("🔥 Lua missing node: ${node.javaClass.simpleName}")
            }


            builder.append("\n")
        }
    }

    fun function(f: JassFun) {
        builder.append("\n")
        if (f.native) builder.append("--- native\n")
        f.param.forEach {
            if (reserved(it.name)) {
                it.name += "_anal"
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

        builder.append("end\n")
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

        jass.globals.forEach(::global)

        builder.append("\n")

        jass.functions.forEach(::function)

        File(output.absolute().toString()).writeText(builder.toString().trim())
    }
}
