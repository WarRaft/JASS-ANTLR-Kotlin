package io.github.warraft.jass.antlr.converter

import io.github.warraft.jass.antlr.JassFakeName
import io.github.warraft.jass.antlr.JassState
import io.github.warraft.jass.antlr.psi.IJassNode
import io.github.warraft.jass.antlr.psi.IJassType
import io.github.warraft.jass.antlr.psi.JassExprOp
import io.github.warraft.jass.antlr.psi.JassFun
import io.github.warraft.jass.antlr.psi.JassHandleType
import io.github.warraft.jass.antlr.psi.JassVar
import java.io.File
import java.nio.file.Path
import kotlin.io.path.absolute

abstract class JassBase(
    val state: JassState,
    val output: Path,
    val fakename: Boolean = false,
) {
    val builder = StringBuilder()

    fun tab(c: Int): StringBuilder {
        (0..c).forEach { builder.append("\t") }
        return builder
    }

    open fun isKeyword(s: String): Boolean = false

    abstract fun typename(type: IJassType, array: Boolean = false): String

    fun varname(v: JassVar): String {
        val root = v.root
        var name = root.name
        return if (fakename || isKeyword(name)) root.fakename else name
    }

    fun funname(f: JassFun): String {
        val root = f.root
        var name = root.name
        return if ((fakename || isKeyword(name)) && !f.native) root.fakename else name
    }

    abstract fun type(t: JassHandleType)

    abstract fun function(f: JassFun)

    abstract fun global(v: JassVar)

    open fun globals() {
        state.globals.forEach(::global)
    }

    open fun opname(op: JassExprOp, a: IJassNode, b: IJassNode): String = when (op) {
        JassExprOp.Mul -> "*"
        JassExprOp.Div -> "/"
        JassExprOp.Add -> "+"
        JassExprOp.Sub -> "-"

        JassExprOp.Lt -> "<"
        JassExprOp.LtEq -> "<="
        JassExprOp.Gt -> ">"
        JassExprOp.GtEq -> ">="

        JassExprOp.Eq -> "=="
        JassExprOp.Neq -> "!="

        JassExprOp.And -> "and"
        JassExprOp.Or -> "or"

        JassExprOp.UnSub -> "-"
        JassExprOp.UnNot -> "not "
        JassExprOp.Get,
        JassExprOp.Set,
        JassExprOp.Paren,
            -> {
            println("⚠️Unexpected operator: $op")
            ""
        }
    }

    abstract fun expr(e: IJassNode?)

    open fun expr(op: JassExprOp, a: IJassNode, b: IJassNode) {
        expr(a)
        builder
            .append(" ")
            .append(opname(op, a, b))
            .append(" ")
        expr(b)
    }

    fun convert() {
        JassFakeName(state = state)

        builder.clear()

        state.types.forEach(::type)
        builder.append("\n")
        state.natives.forEach(::function)
        builder.append("\n")
        globals()
        builder.append("\n")
        state.functions.forEach(::function)

        File(output.absolute().toString()).writeText(builder.toString().trim())
    }

    init {
        convert()
    }
}
