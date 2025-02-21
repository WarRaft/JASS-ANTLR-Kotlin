package io.github.warraft.jass.antlr.psi

import io.github.warraft.JassParser.*
import io.github.warraft.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.jass.antlr.psi.base.JassTypeBase
import io.github.warraft.jass.antlr.state.JassState
import io.github.warraft.jass.antlr.state.ext.antlr.expr
import io.github.warraft.jass.antlr.state.ext.antlr.typeFromString
import io.github.warraft.jass.lsp4j.diagnostic.JassDiagnosticCode.ERROR
import io.github.warraft.languages.lsp4j.service.document.semantic.token.SemanticTokenModifier.DEFINITION
import io.github.warraft.languages.lsp4j.service.document.semantic.token.SemanticTokenType.*
import io.github.warraft.languages.lsp4j.utils.DiagnosticRelatedInformationEx
import io.github.warraft.languages.lsp4j.utils.RangeEx
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.tree.TerminalNode
import org.eclipse.lsp4j.Range
import org.eclipse.lsp4j.SymbolKind


class JassVar(
    val state: JassState,
) : JassNodeBase() {
    lateinit var scope: JassVarScope

    var symbol: Token? = null

    override var type: JassTypeBase? = null
    var name: String? = null
    var fakename: String = ""

    var array: Boolean = false

    var constant: Boolean = false
    var global: Boolean = false
    var local: Boolean = false
    var param: Boolean = false

    var index: JassExpr? = null
    var expr: JassExpr? = null

    var definition: ParserRuleContext? = null

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
                it.scope = function?.varScope ?: state.varScope
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
                        state.diagnosticHub.add(ctx, ERROR, "Missing name")
                        return null
                    }
                    if (typeCtx == null) {
                        state.diagnosticHub.add(ctx, ERROR, "Missing type")
                        return null
                    }

                    val typeName = typeCtx.text

                    state.semanticHub
                        .add(nameCtx, PARAMETER, DEFINITION)
                        .add(typeCtx, TYPE_PARAMETER)

                    v.also {
                        it.constant = constantCtx != null
                        it.name = nameCtx.text
                        it.type = state.typeFromString(typeName)
                        it.array = arrayCtx != null

                        if (global) for (s in state.states + state) {
                            val d = s.varScope.definition(it)
                            if (d == null) continue
                            state
                                .diagnosticHub
                                .add(
                                    nameCtx, ERROR, "Variable redeclared",
                                    listOf(DiagnosticRelatedInformationEx.get(d, "First declaration of '${d.name}' is here"))
                                )
                        }

                        it.scope.add(it, true)
                    }

                    when (ctx) {
                        is ParamContext -> {
                            if (function?.documentSymbol != null) state.documentSymbolHub.add(ctx, nameCtx, SymbolKind.Variable, function.documentSymbol).also { it?.detail = typeName }
                            v.also {
                                it.param = true
                            }
                        }

                        is VariableContext -> {
                            if (eqCtx != null) {
                                exprCtx = ctx.expr()
                                v.expr = state.expr(exprCtx, function)
                                if (v.expr == null) {
                                    if (v.array) state.diagnosticHub.add(eqCtx, ERROR, "Cannot set array")
                                    else state.diagnosticHub.add(eqCtx, ERROR, "Missing expression")
                                } else {
                                    if (v.array) {
                                        state.diagnosticHub.add(exprCtx, ERROR, "Cannot set array")
                                    } else {
                                        val ta: JassTypeBase? = v.type
                                        val tb: JassTypeBase? = v.expr?.type
                                        if (ta == null || tb == null) {
                                            state.diagnosticHub.add(nameCtx, ERROR, "Type error")
                                        } else {
                                            val t = ta.op(JassExprOp.Set, tb)
                                            if (t is JassUndefinedType) {
                                                state.diagnosticHub.add(exprCtx, ERROR, "Cannot set ${ta.name} with ${tb.name}")
                                            }
                                        }
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
                        if (global) state.globals.add(v)
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
                it.expr = state.expr(exprCtx, function)
                it.index = state.expr(indexCtx, function)
            }

            if (nameCtx == null) {
                state.diagnosticHub.add(ctx, ERROR, "Missing name")
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

            var d: JassVar? = function?.varScope?.definition(v.name)
            d.let { function?.varScope?.add(v) }

            if (d == null) {
                d = state.varScope.definition(v.name)
                state.varScope.add(v)
            }

            if (d == null) for (s in state.states) {
                d = s.varScope.definition(v.name)
                if (d != null) break
            }

            if (d == null) {
                state.diagnosticHub.add(ctx, ERROR, "Variable is not declared")
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

            var brackRange: Range = RangeEx.get(lBrackCtx, rBrackCtx) ?: RangeEx.get(nameCtx)

            if (d.array) {
                val i = v.index
                if (i == null) {
                    state.diagnosticHub.add(brackRange, ERROR, "Missing index")
                } else {
                    if (JassIntType().op(JassExprOp.Set, i.type) !is JassIntType) {
                        state.diagnosticHub.add(brackRange, ERROR, "Index must be an integer, ${i.type.name} passed")
                    }
                }
            } else {
                if (lBrackCtx != null || rBrackCtx != null) {
                    state.diagnosticHub.add(brackRange, ERROR, "Array access to non array variable")
                }
            }

            when (ctx) {
                is StmtSetContext -> {
                    if (v.expr == null) {
                        state.diagnosticHub.add(nameCtx, ERROR, "Missing expression")
                        return v
                    }

                    if (v.constant) {
                        state.diagnosticHub.add(nameCtx, ERROR, "Cannot set constant")
                        return v
                    }

                    val ta = d.type
                    val tb = v.expr?.type

                    if (ta == null || tb == null) {
                        state.diagnosticHub.add(ctx, ERROR, "Some type is null")
                    } else {
                        if (ta.op(JassExprOp.Set, tb) is JassUndefinedType) {
                            state.diagnosticHub.add(
                                exprCtx, ERROR, "Can't set ${ta.name} with ${tb.name}"
                            )
                        }
                    }
                }
            }

            return v
        }
    }
}
