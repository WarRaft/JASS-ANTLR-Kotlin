package io.github.warraft.language.jass.psi

import io.github.warraft.JassParser.*
import io.github.warraft.language.jass.psi.JassTypeName.Companion.INTEGER
import io.github.warraft.language.jass.psi.base.JassNodeBase
import io.github.warraft.language.jass.state.JassState
import io.github.warraft.lsp.data.DiagnosticCode.ERROR
import io.github.warraft.lsp.data.*
import io.github.warraft.lsp.data.semantic.SemanticTokenModifier.DEFINITION
import io.github.warraft.lsp.data.semantic.SemanticTokenType.*
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.TerminalNode

class JassVar(override val state: JassState) : JassNodeBase() {
    lateinit var scope: JassVarScope

    var array: Boolean = false

    var constant: Boolean = false
    var global: Boolean = false
    var local: Boolean = false
    var param: Boolean = false

    var index: JassExpr? = null
    var expr: JassExpr? = null

    override fun toString(): String {
        val list: MutableList<String> = mutableListOf()

        if (global) {
            if (constant) list.add("constant")
            list.add("global")
        }

        if (param) list.add("param")
        else if (local) list.add("local")

        type?.let { list.add(type!!.name) }

        if (array) list.add("[]")

        var n = ""
        list.add(n + name)

        if (expr != null) {
            list.add("=")
            list.add(expr!!.toString())
        }

        return return list.joinToString(" ")
    }

    companion object {
        fun parse(
            ctx: ParserRuleContext?,
            function: JassFun?,
            state: JassState,
        ): JassVar? {
            if (ctx == null) return null
            var nameCtx: TerminalNode? = null
            var exprCtx: ExprContext? = null
            var eqCtx: TerminalNode? = null
            var indexCtx: ExprContext? = null
            var lBrackCtx: TerminalNode? = null
            var rBrackCtx: TerminalNode? = null

            var v = JassVar(
                state = state,
            ).also {
                it.definition = ctx
            }

            when (ctx) {
                //region ParamContext, VariableContext
                is ParamContext,
                is VariableContext,
                    -> {
                    val global = function == null
                    var typeCtx: TerminalNode? = null
                    var arrayCtx: TerminalNode? = null
                    var constantCtx: TerminalNode? = null
                    when (ctx) {
                        is ParamContext -> {
                            nameCtx = ctx.varname()?.ID()
                            typeCtx = ctx.typename()?.ID()
                        }

                        is VariableContext -> {
                            nameCtx = ctx.varname()?.ID()
                            typeCtx = ctx.typename()?.ID()
                            arrayCtx = ctx.ARRAY()
                            constantCtx = ctx.CONSTANT()
                            eqCtx = ctx.EQ()

                            state.semanticHub
                                .add(constantCtx, KEYWORD)
                                .add(ctx.LOCAL(), KEYWORD)
                                .add(arrayCtx, KEYWORD)
                                .add(eqCtx, OPERATOR)
                        }
                    }

                    if (nameCtx == null) {
                        Diagnostic(
                            range = Range.of(ctx) ?: Range.zero,
                            message = "Missing name",
                            code = ERROR,
                        ).also {
                            state.diagnostic.add(it)
                        }
                        return null
                    }

                    val type = JassType.part(typeCtx, state)

                    if (type == null) {
                        Diagnostic(
                            range = Range.of(ctx) ?: Range.zero,
                            message = "Missing type",
                            code = ERROR,
                        ).also {
                            state.diagnostic.add(it)
                        }
                        return null
                    }

                    state.semanticHub
                        .add(nameCtx, PARAMETER, DEFINITION)
                        .add(typeCtx, TYPE_PARAMETER)

                    v.also {
                        it.constant = constantCtx != null
                        it.type = type.type
                        it.name = nameCtx.text
                        it.array = arrayCtx != null
                        it.scope = function?.varScope ?: state.varScope

                        if (global) for (s in state.states + state) {
                            val d = s.varScope.definition(it)
                            if (d == null) continue
                            Diagnostic(
                                range = Range.of(nameCtx) ?: Range.zero,
                                severity = DiagnosticSeverity.Error,
                                code = ERROR,
                                message = "Variable redeclared",
                            ).also {
                                it.relatedInformation(d, "First declaration of '${d.name}' is here")
                                state.diagnostic.add(it)
                            }
                        }

                        it.scope.add(it, true)
                    }

                    when (ctx) {
                        is ParamContext -> {

                            function?.documentSymbol?.append(
                                DocumentSymbol(
                                    name = v.name ?: "unnamed",
                                    kind = SymbolKind.Variable,
                                    range = Range.of(ctx) ?: Range.zero,
                                    selectionRange = Range.of(nameCtx) ?: Range.zero,
                                    detail = type.name,
                                )
                            )
                            v.also {
                                it.param = true
                            }
                        }

                        is VariableContext -> {
                            if (eqCtx != null) {
                                exprCtx = ctx.expr()
                                v.expr = JassExpr.parse(state, exprCtx, function)

                                if (v.array) {
                                    Diagnostic(
                                        range = Range.of(exprCtx) ?: Range.of(eqCtx) ?: Range.zero,
                                        message = "Cannot set array",
                                        code = ERROR,
                                    ).also {
                                        state.diagnostic.add(it)
                                    }
                                } else {
                                    if (v.expr == null) {
                                        Diagnostic(
                                            range = Range.of(eqCtx) ?: Range.zero,
                                            message = "Missing expression",
                                            code = ERROR,
                                        ).also {
                                            state.diagnostic.add(it)
                                        }
                                    } else {
                                        v.typeCheck(JassExprOp.SET, v.expr)
                                    }
                                }
                            }
                        }
                    }

                    return v.also {
                        v.global = global
                        v.local = !global
                        it.symbol = nameCtx.symbol
                        state.tokenTree.add(it)
                        if (global) state.varScope.globals.add(v)
                        else function.param.add(it)
                    }
                }
                //endregion

                //region StmtSetContext
                is StmtSetContext -> {
                    nameCtx = ctx.ID()
                    eqCtx = ctx.EQ()
                    exprCtx = ctx.expr()
                    val b: SetBrackContext? = ctx.setBrack()
                    lBrackCtx = b?.LBRACK()
                    rBrackCtx = b?.RBRACK()
                    indexCtx = b?.expr()
                    state.semanticHub.add(ctx.SET(), KEYWORD)
                }
                //endregion

                //region ExprVarContext
                is ExprVarContext -> {
                    nameCtx = ctx.ID()
                }
                //endregion

                //region ExprArrContext
                is ExprArrContext -> {
                    nameCtx = ctx.ID()
                    lBrackCtx = ctx.LBRACK()
                    rBrackCtx = ctx.RBRACK()
                    indexCtx = ctx.expr()
                }
                //endregion
            }

            v.also {
                it.expr = JassExpr.parse(state, exprCtx, function)
                it.index = JassExpr.parse(state, indexCtx, function)
            }

            if (nameCtx == null) {
                Diagnostic(
                    range = Range.of(ctx) ?: Range.zero,
                    message = "Missing name",
                    severity = DiagnosticSeverity.Error,
                    code = ERROR
                ).also {
                    state.diagnostic.add(it)
                }
                return null
            }

            v.also {
                it.name = nameCtx.text
                it.symbol = nameCtx.symbol
                state.tokenTree.add(it)
            }

            state.semanticHub
                .add(eqCtx, OPERATOR)
                .add(v.symbol, VARIABLE)

            val fscope = function?.varScope

            var d: JassVar? = fscope?.definition(v.name)
            if (d == null) {
                d = state.varScope.definition(v.name)
                state.varScope.add(v)
            } else {
                fscope?.add(v)
            }

            if (d == null) for (s in state.states) {
                d = s.varScope.definition(v.name)
                if (d != null) break
            }

            if (d == null) {
                Diagnostic(
                    range = Range.of(ctx) ?: Range.zero,
                    message = "Variable is not declared",
                    code = ERROR,
                ).also {
                    state.diagnostic.add(it)
                }
                return v
            }

            v.also {
                it.type = d.type
                it.array = d.array
                it.constant = d.constant
                it.global = d.global
                it.local = d.local
                it.param = d.param
            }

            var brackRange: Range = Range.of(lBrackCtx, rBrackCtx) ?: Range.of(v.symbol) ?: Range.zero

            if (d.array) {
                val i = v.index
                if (i == null) {
                    Diagnostic(
                        range = brackRange,
                        severity = DiagnosticSeverity.Error,
                        code = ERROR,
                        message = "Missing index",
                    ).also {
                        state.diagnostic.add(it)
                    }
                } else {
                    val itype = i.type?.name
                    if (itype != INTEGER) {
                        Diagnostic(
                            range = brackRange,
                            severity = DiagnosticSeverity.Error,
                            code = ERROR,
                            message = "Index must be an integer, $itype passed",
                        ).also {
                            state.diagnostic.add(it)
                        }
                    }
                }
            } else {
                if (lBrackCtx != null || rBrackCtx != null) {
                    Diagnostic(
                        range = brackRange,
                        severity = DiagnosticSeverity.Error,
                        code = ERROR,
                        message = "Array access to non array variable",
                    ).also {
                        state.diagnostic.add(it)
                    }
                }
            }

            when (ctx) {
                is StmtSetContext -> {
                    if (v.expr == null) {
                        Diagnostic(
                            range = Range.of(nameCtx) ?: Range.zero,
                            message = "Missing expression",
                            code = ERROR,
                        ).also {
                            state.diagnostic.add(it)
                        }
                        return v
                    }

                    if (v.constant) {
                        Diagnostic(
                            range = Range.of(nameCtx) ?: Range.zero,
                            message = "Cannot set constant",
                            code = ERROR,
                        ).also {
                            state.diagnostic.add(it)
                        }
                        return v
                    }

                    d.typeCheck(JassExprOp.SET, v.expr)
                }
            }

            return v
        }
    }
}
