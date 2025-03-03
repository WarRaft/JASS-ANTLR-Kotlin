package io.github.warraft.language.jass.antlr.psi.base

import io.github.warraft.language.jass.antlr.psi.JassExprOp
import io.github.warraft.language.jass.antlr.psi.JassExprOp.*
import io.github.warraft.language.jass.antlr.psi.JassType
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
import io.github.warraft.lsp.data.DiagnosticCode
import io.github.warraft.lsp.data.Diagnostic
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
        var a = this.type?.name ?: return null
        var b = node?.type?.name ?: return null

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
                    else -> if (JassType.handleTree(b, state).lastOrNull() == HANDLE) type = BOOLEAN

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
                    STRING, NULL -> type = BOOLEAN
                }

                SET -> when (b) {
                    STRING, NULL -> type = STRING
                }

                else -> {}
            }

            else -> {
                val aa = JassType.handleTree(a, state)
                if (aa.lastOrNull() == HANDLE) {
                    when (op) {
                        EQ, NEQ -> when (b) {
                            a, NULL -> type = BOOLEAN
                        }

                        SET -> {
                            when (b) {
                                NULL -> type = BOOLEAN
                                else -> {
                                    val bb = JassType.handleTree(b, state)
                                    for (b in bb) {
                                        if (b != a) continue
                                        type = BOOLEAN
                                        break
                                    }
                                }
                            }
                        }

                        else -> {}
                    }
                }
            }

        }

        if (type == null) {
            Diagnostic(
                range = when (op) {
                    SET -> Range.of(node.definition) ?: Range.zero
                    else -> Range.of(definition, node.definition) ?: Range.zero
                },
                message = "Cannot resolve operation $op between $a and $b",
                code = DiagnosticCode.ERROR,
            ).also {
                it.relatedInformation(this, a)
                it.relatedInformation(node, b)
                state.diagnostic.add(it)
            }
            type = UNDEFINED
        }

        return JassTypeName(type)
    }
}
