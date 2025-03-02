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
import io.github.warraft.language.jass.lsp.diagnostic.JassDiagnosticCode
import io.github.warraft.lsp.data.Diagnostic
import io.github.warraft.lsp.data.DiagnosticRelatedInformation
import io.github.warraft.lsp.data.Location
import io.github.warraft.lsp.data.Range
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.Token

abstract class JassNodeBase() {
    abstract val state: JassState
    open var type: JassTypeName? = null
    var name: String? = null

    var symbol: Token? = null
    var definition: ParserRuleContext? = null

    fun typeCheck(op: JassExprOp?, node: JassNodeBase?): JassTypeName? {
        val a = this.type?.name ?: return null
        val b = node?.type?.name ?: return null

        var type: String? = null
        when (a) {
            INTEGER -> when (op) {
                ADD, SUB, MUL, DIV -> when (b) {
                    INTEGER -> type = INTEGER
                    REAL -> type = REAL
                }

                LT, LTEQ, GT, GTEQ -> when (b) {
                    INTEGER, REAL -> type = BOOLEAN
                }

                EQ, NEQ -> when (b) {
                    INTEGER, REAL, NULL -> type = BOOLEAN
                }

                SET -> when (b) {
                    INTEGER -> type = INTEGER
                }

                else -> {}
            }

            REAL -> when (op) {
                ADD, SUB, MUL, DIV -> when (b) {
                    INTEGER, REAL -> type = REAL
                }

                LT, LTEQ, GT, GTEQ -> when (b) {
                    INTEGER, REAL -> type = BOOLEAN
                }

                EQ, NEQ -> when (b) {
                    INTEGER, REAL, NULL -> type = BOOLEAN
                }

                SET -> when (b) {
                    INTEGER, REAL -> type = REAL
                }

                else -> {}
            }

            BOOLEAN -> when (op) {
                SET -> when (b) {
                    BOOLEAN -> type = BOOLEAN
                }

                AND, OR -> when (b) {
                    BOOLEAN -> type = BOOLEAN
                }

                EQ, NEQ -> when (b) {
                    BOOLEAN, NULL -> type = BOOLEAN
                }

                else -> {}
            }

            NULL -> when (op) {
                EQ, NEQ -> when (b) {
                    NULL, INTEGER, REAL, STRING, HANDLE -> type = BOOLEAN
                }

                else -> {}
            }

            CODE -> when (op) {
                SET -> when (b) {
                    CODE, NULL -> type = CODE
                }

                else -> {}
            }

            STRING -> when (op) {
                ADD -> when (b) {
                    STRING -> type = STRING
                }

                EQ, NEQ -> when (b) {
                    STRING, NULL -> type = STRING
                }

                SET -> when (b) {
                    STRING, NULL -> type = STRING
                }

                else -> {}
            }
        }

        if (type == null) {
            Diagnostic(
                range = Range.of(definition, node.definition) ?: Range.zero,
                message = "Cannot resolve operation $op between:",
                code = JassDiagnosticCode.ERROR.name,
            ).also {
                it.relatedInformation(this, a)
                it.relatedInformation(node, b)
                state.diagnosticHub.add(it)
            }
            type = UNDEFINED
        }

        return JassTypeName(type)
    }
}
