package io.github.warraft.jass.antlr.psi

import io.github.warraft.JassParser.*
import io.github.warraft.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.jass.antlr.psi.base.JassTypeBase
import io.github.warraft.jass.antlr.psi.utils.JassVarScope
import io.github.warraft.jass.antlr.state.JassState
import io.github.warraft.jass.antlr.state.ext.antlr.expr
import io.github.warraft.jass.antlr.state.ext.antlr.typeFromString
import io.github.warraft.jass.lsp4j.diagnostic.JassDiagnosticCode.ERROR
import io.github.warraft.languages.lsp4j.service.document.semantic.token.SemanticTokenModifier.DEFINITION
import io.github.warraft.languages.lsp4j.service.document.semantic.token.SemanticTokenType.*
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.tree.TerminalNode
import org.eclipse.lsp4j.SymbolKind

class JassVar(
) : JassNodeBase() {
    var state: JassState? = null
    var scope: JassVarScope? = null
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

            var v = JassVar().also {
                it.state = state
                it.scope = function?.scopeVar ?: state.scopeVar
                it.definition = ctx
            }

            when (ctx) {
                //region ParamContext, VariableContext
                is ParamContext,
                is VariableContext,
                    -> {
                    var typeCtx: TerminalNode? = null
                    val global = function == null
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
                    }

                    when (ctx) {
                        is ParamContext -> {
                            if (function?.documentSymbol != null) state.documentSymbolHub.add(ctx, nameCtx, SymbolKind.Variable, function.documentSymbol).also { it?.detail = typeName }
                            v.also {
                                it.local = true
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

                            if (global) for (s in state.states) {
                                val d = s.scopeVar.definition(v.name)
                                if (d == null) continue
                                state.diagnosticHub.add(nameCtx, ERROR, "redeclared")
                            }
                        }
                    }

                    return v.also {
                        v.global = global
                        v.local = !global
                        it.symbol = nameCtx.symbol
                        state.tokenTree.add(it)
                        it.scope?.definition(it)
                        if (global) {
                            state.globals.add(v)
                        } else {
                            function.param.add(it)
                        }
                    }
                }
                //endregion

                //region ExprVarContext
                is ExprVarContext -> {
                    nameCtx = ctx.ID()
                }
                //endregion

                //region StmtSetContext
                is StmtSetContext -> {
                    nameCtx = ctx.ID()
                    eqCtx = ctx.EQ()
                    exprCtx = ctx.expr()
                }
                //endregion

                //region ExprArrContext
                is ExprArrContext -> {
                    nameCtx = ctx.ID()
                    state.semanticHub.add(nameCtx, VARIABLE)

                    val name = nameCtx.text
                    var node: JassNodeBase? = state.getNode(name, function)
                    if (node !is JassVar) {
                        state.diagnosticHub.add(
                            nameCtx,
                            ERROR,
                            "$name array is not declared"
                        )
                        return null
                    }
                    return null
                    /*
                    return JassExpr(
                        op = JassExprOp.Get,
                        a = node.clone(
                            state = this,
                            index = expr(exprCtx.expr(), function),
                            symbol = idctx.symbol
                        ).also {
                            tokenTree.add(it)
                            it.scope?.link(it)
                        },
                    )

                     */
                }
                //endregion
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

            var d: JassVar? = function?.scopeVar?.definition(v.name)
            d.let { function?.scopeVar?.link(v) }

            if (d == null) {
                d = state.scopeVar.definition(v.name)
                state.scopeVar.link(v)
            }

            if (d == null) for (s in state.states) {
                d = s.scopeVar.definition(v.name)
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

            when (ctx) {
                is StmtSetContext -> {
                    state.semanticHub
                        .add(nameCtx, VARIABLE)
                        .add(ctx.SET(), KEYWORD)


                    var node: JassNodeBase? = null
                    if (nameCtx == null) {
                        state.diagnosticHub.add(ctx, ERROR, "Variable name is missing")
                    } else {
                        val name = nameCtx.text
                        node = state.getNode(name, function)
                        if (node !is JassVar) {
                            state.diagnosticHub.add(nameCtx, ERROR, "Set must be a variable")
                        }
                    }

                    val exprCtx = ctx.expr()
                    val e = state.expr(exprCtx, function)
                    if (e == null) {
                        state.diagnosticHub.add(
                            ctx.SET(),
                            ERROR,
                            "Missing expression"
                        )
                        return null
                    }

                    if (node is JassVar) {
                        val brack: SetBrackContext? = ctx.setBrack()
                        val eBrack = state.expr(brack?.expr(), function)

                        /*
                        val v = node.clone(
                            state = this,
                            expr = e,
                            index = eBrack,
                            symbol = nameCtx?.symbol
                        ).also {
                            tokenTree.add(it)
                        }

                        if (v.type.op(JassExprOp.Set, e.type) is JassUndefinedType) {
                            diagnosticHub.add(
                                exprCtx,
                                JassDiagnosticCode.ERROR,
                                "Can't set ${v.type.name} with ${e.type.name}"
                            )
                        }

                        list.add(v)

                         */
                    }
                }
            }

            return v
        }
    }
}
