package io.github.warraft.language.jass.antlr.psi.base

import io.github.warraft.language.jass.antlr.psi.JassExprOp
import io.github.warraft.language.jass.antlr.psi.JassExprOp.*
import io.github.warraft.language.jass.antlr.psi.JassTypeName
import io.github.warraft.language.jass.antlr.psi.JassTypeName.Companion.BOOLEAN
import io.github.warraft.language.jass.antlr.psi.JassTypeName.Companion.CODE
import io.github.warraft.language.jass.antlr.psi.JassTypeName.Companion.HANDLE
import io.github.warraft.language.jass.antlr.psi.JassTypeName.Companion.INTEGER
import io.github.warraft.language.jass.antlr.psi.JassTypeName.Companion.NULL
import io.github.warraft.language.jass.antlr.psi.JassTypeName.Companion.REAL
import io.github.warraft.language.jass.antlr.psi.JassTypeName.Companion.STRING
import io.github.warraft.language.jass.antlr.psi.JassTypeName.Companion.UNDEFINED
import io.github.warraft.language.jass.antlr.state.JassState
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.Token

abstract class JassNodeBase() {
    abstract val state: JassState
    open var type: JassTypeName? = null
    var name: String? = null

    var symbol: Token? = null
    var definition: ParserRuleContext? = null

    fun typecheck(op: JassExprOp?, node: JassNodeBase?): JassTypeName? {
        val a = type?.name ?: return null
        val b = node?.type?.name ?: return null

        val out: String? = when (a) {
            INTEGER -> when (op) {
                ADD, SUB, MUL, DIV -> when (b) {
                    INTEGER -> INTEGER
                    REAL -> REAL
                    else -> UNDEFINED
                }

                LT, LTEQ, GT, GTEQ -> when (b) {
                    INTEGER, REAL -> BOOLEAN
                    else -> UNDEFINED
                }

                EQ, NEQ -> when (b) {
                    INTEGER, REAL, NULL -> BOOLEAN
                    else -> UNDEFINED
                }

                SET -> when (b) {
                    INTEGER -> INTEGER
                    else -> UNDEFINED
                }

                else -> UNDEFINED
            }

            REAL -> when (op) {
                ADD, SUB, MUL, DIV -> when (b) {
                    INTEGER, REAL -> REAL
                    else -> UNDEFINED
                }

                LT, LTEQ, GT, GTEQ -> when (b) {
                    INTEGER, REAL -> BOOLEAN
                    else -> UNDEFINED
                }

                EQ, NEQ -> when (b) {
                    INTEGER, REAL, NULL -> BOOLEAN
                    else -> UNDEFINED
                }

                SET -> when (b) {
                    INTEGER, REAL -> REAL
                    else -> UNDEFINED
                }

                else -> UNDEFINED
            }

            BOOLEAN -> when (op) {
                SET -> when (b) {
                    BOOLEAN -> BOOLEAN
                    else -> UNDEFINED
                }

                AND, OR -> when (b) {
                    BOOLEAN -> BOOLEAN
                    else -> UNDEFINED
                }

                EQ, NEQ -> when (b) {
                    BOOLEAN, NULL -> BOOLEAN
                    else -> UNDEFINED
                }

                else -> UNDEFINED
            }

            NULL -> when (op) {
                EQ, NEQ -> when (b) {
                    NULL, INTEGER, REAL, STRING, HANDLE -> BOOLEAN
                    else -> UNDEFINED
                }

                else -> UNDEFINED
            }

            CODE -> when (op) {
                SET -> when (b) {
                    CODE, NULL -> CODE
                    else -> UNDEFINED
                }

                else -> UNDEFINED
            }

            STRING -> when (op) {
                ADD -> when (b) {
                    STRING -> STRING
                    else -> UNDEFINED
                }

                EQ, NEQ -> when (b) {
                    STRING, NULL -> STRING
                    else -> UNDEFINED
                }

                SET -> when (b) {
                    STRING, NULL -> STRING
                    else -> UNDEFINED
                }

                else -> UNDEFINED
            }

            else -> UNDEFINED
        }

        return if (out == null) null else JassTypeName(out)
    }
}
