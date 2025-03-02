package io.github.warraft.language.jass.antlr.psi

import io.github.warraft.JassParser.*
import io.github.warraft.language.jass.antlr.psi.JassTypeName.Companion.CODE
import io.github.warraft.language.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.language.jass.antlr.state.JassState
import io.github.warraft.language.jass.antlr.state.ext.antlr.stmt
import io.github.warraft.lsp.data.DiagnosticCode.ERROR
import io.github.warraft.lsp.data.*
import io.github.warraft.lsp.data.semantic.SemanticTokenModifier.DECLARATION
import io.github.warraft.lsp.data.semantic.SemanticTokenModifier.DOCUMENTATION
import io.github.warraft.lsp.data.semantic.SemanticTokenType
import io.github.warraft.lsp.data.semantic.SemanticTokenType.COMMENT
import io.github.warraft.lsp.data.semantic.SemanticTokenType.KEYWORD
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.TerminalNode

class JassFun(override val state: JassState) : JassNodeBase() {

    val varScope: JassVarScope = JassVarScope(
        state = state,
        function = this
    )
    lateinit var scope: JassFunScope

    val param: MutableList<JassVar> = mutableListOf()
    val arg: MutableList<JassExpr> = mutableListOf()
    val stmt: MutableList<JassNodeBase> = mutableListOf()

    val comments = StringBuilder()

    var documentSymbol: DocumentSymbol? = null

    var native: Boolean = false
    var ref: Boolean = false

    override fun toString(): String = "JassFun(name='$name'):$type"

    companion object {
        fun parse(
            ctx: ParserRuleContext?,
            function: JassFun?,
            state: JassState,
        ): JassFun? {
            if (ctx == null) return null

            var nameCtx: TerminalNode? = null
            var lParenCtx: TerminalNode? = null
            var rParenCtx: TerminalNode? = null
            var exprsCtx: List<ExprContext>? = null

            val f = JassFun(state)

            when (ctx) {
                is NativeRuleContext,
                is FunctionContext,
                    -> {
                    var takesCtx: TakesContext? = null
                    var returnsCtx: ReturnsRuleContext? = null

                    //region Comments
                    val comments = mutableListOf<String>()
                    for (i in ctx.start.line - 1 downTo 0) {
                        val m = state.tokenFactory.commentMap
                        val t = m[i]
                        if (t == null) break
                        m.remove(i)
                        comments.addFirst(t.text.replaceFirst("^//\\s?".toRegex(), ""))
                        state.semanticHub.add(t, COMMENT, DOCUMENTATION)
                    }
                    for (c in comments) {
                        f.comments.append(c).append("\n")
                    }
                    //endregion

                    // === head
                    when (ctx) {
                        //region NativeRuleContext
                        is NativeRuleContext -> {
                            f.native = true

                            nameCtx = ctx.ID()
                            takesCtx = ctx.takes()
                            returnsCtx = ctx.returnsRule()

                            val nativeCtx = ctx.NATIVE()
                            if (nameCtx == null) Diagnostic(
                                range = Range.of(nativeCtx) ?: Range.zero,
                                message = "Native name is missing",
                                code = ERROR,
                            ).also {
                                state.diagnostic.add(it)
                            }

                            state.semanticHub
                                .add(nativeCtx, KEYWORD)
                                .add(ctx.CONSTANT(), KEYWORD)
                        }
                        //endregion

                        //region FunctionContext
                        is FunctionContext -> {
                            nameCtx = ctx.ID()
                            takesCtx = ctx.takes()
                            returnsCtx = ctx.returnsRule()

                            val functionCtx = ctx.FUNCTION()
                            val enfunctionCtx = ctx.ENDFUNCTION()

                            if (nameCtx == null) Diagnostic(
                                range = Range.of(functionCtx) ?: Range.zero,
                                message = "Function name is missing",
                                code = ERROR,
                            ).also {
                                state.diagnostic.add(it)
                            }

                            state.semanticHub
                                .add(ctx.CONSTANT(), KEYWORD)
                                .add(functionCtx, KEYWORD)
                                .add(enfunctionCtx, KEYWORD)

                            FoldingRange.of(functionCtx, enfunctionCtx)?.also {
                                it.kind = FoldingRangeKind.Region
                                state.foldingRange.add(it)
                            }
                        }
                        //endregion
                    }


                    //region Name
                    if (nameCtx != null) {
                        var name = nameCtx.text

                        f.also {
                            it.symbol = nameCtx.symbol
                            it.name = name
                            it.definition = ctx
                            state.tokenTree.add(it)

                            f.documentSymbol = DocumentSymbol(
                                name = name,
                                kind = SymbolKind.Function,
                                range = Range.of(ctx) ?: Range.zero,
                                selectionRange = Range.of(nameCtx) ?: Range.zero,
                            ).also {
                                state.documentSymbol.add(it)
                            }
                        }

                        state.semanticHub.add(nameCtx, SemanticTokenType.FUNCTION, DECLARATION)

                        for (s in state.states + state) {
                            val d = s.funScope.definition(f)
                            if (d == null) continue
                            Diagnostic(
                                range = Range.of(nameCtx) ?: Range.zero,
                                severity = DiagnosticSeverity.Error,
                                code = ERROR,
                                message = "Function redeclared",
                            ).also {
                                it.relatedInformation(d, "First declaration of '${d.name}' is here")
                                state.diagnostic.add(it)
                            }
                        }

                        state.funScope.add(f, true)
                    }
                    //endregion

                    //region Holder
                    state.funScope.also {
                        if (f.native) it.natives.add(f)
                        else it.functions.add(f)
                    }
                    //endregion

                    //region Takes
                    if (takesCtx != null) {
                        val nothingCtx = takesCtx.NOTHING()
                        state.semanticHub
                            .add(nothingCtx, KEYWORD)
                            .add(takesCtx.TAKES(), KEYWORD)

                        if (nothingCtx == null) {
                            for (ctx in takesCtx.param()) JassVar.parse(ctx, f, state)
                        }
                    }
                    //endregion

                    //region Returns
                    if (returnsCtx != null) {
                        val nothingCtx = returnsCtx.NOTHING()
                        state.semanticHub
                            .add(nothingCtx, KEYWORD)
                            .add(returnsCtx.RETURNS(), KEYWORD)

                        if (nothingCtx == null) {
                            val typeCtx: TerminalNode? = returnsCtx.ID()
                            state.semanticHub.add(typeCtx, SemanticTokenType.TYPE)
                            val type = JassType.part(typeCtx, state)

                            if (type == null) {
                                Diagnostic(
                                    range = Range.of(returnsCtx) ?: Range.zero,
                                    message = "Missing return type",
                                    code = ERROR,
                                ).also {
                                    state.diagnostic.add(it)
                                }
                            } else {
                                f.also {
                                    it.type = type.type
                                    it.documentSymbol?.detail = type.name
                                }

                                if (f.name == "BB") {
                                    state.server?.log("t: ${type}")
                                }
                            }
                        } else {
                            f.type = JassTypeName(JassTypeName.NOTHING)
                        }
                    }
                    //endregion

                    //region Body
                    if (ctx !is FunctionContext) return f
                    for (ctx: VariableContext in ctx.variable()) JassVar.parse(ctx, f, state)
                    state.stmt(ctx.stmt(), f.stmt, f)
                    //endregion
                    return f
                }

                is StmtCallContext -> {
                    nameCtx = ctx.ID()
                    lParenCtx = ctx.LPAREN()
                    rParenCtx = ctx.RPAREN()
                    exprsCtx = ctx.expr()

                    state.semanticHub
                        .add(nameCtx, SemanticTokenType.FUNCTION)
                        .add(ctx.CALL(), KEYWORD)

                    state.semanticHub
                        .add(nameCtx, SemanticTokenType.FUNCTION)
                        .add(ctx.DEBUG(), KEYWORD)
                        .add(ctx.CALL(), KEYWORD)
                }

                is ExprCallContext -> {
                    nameCtx = ctx.ID()
                    lParenCtx = ctx.LPAREN()
                    rParenCtx = ctx.RPAREN()
                    exprsCtx = ctx.expr()
                }

                is ExprFunContext -> {
                    nameCtx = ctx.ID()
                    state.semanticHub.add(ctx.FUNCTION(), KEYWORD)

                    f.also {
                        it.type = JassTypeName(CODE)
                        it.ref = true
                    }
                }
            }

            val exprs = mutableListOf<JassExpr?>()
            if (exprsCtx != null) for (ectx in exprsCtx) {
                exprs.add(JassExpr.parse(state, ectx, function))
            }

            if (nameCtx == null) {
                Diagnostic(
                    range = Range.of(ctx) ?: Range.zero,
                    message = "Function name is missing",
                    code = ERROR,
                ).also {
                    state.diagnostic.add(it)
                }
                return null
            }

            state.semanticHub.add(nameCtx, SemanticTokenType.FUNCTION)

            f.also {
                it.name = nameCtx.text
                it.symbol = nameCtx.symbol
                it.definition = ctx
                state.tokenTree.add(it)
                state.funScope.add(f)
            }

            var d: JassFun? = null

            for (s in state.states + state) {
                d = s.funScope.definition(f)
                if (d != null) break
            }

            if (d == null) {
                Diagnostic(
                    range = Range.of(nameCtx) ?: Range.zero,
                    message = "Function not exists",
                    code = ERROR,
                ).also {
                    state.diagnostic.add(it)
                }
            } else if (exprsCtx != null) {
                f.also {
                    it.type = d.type
                }

                val params = mutableListOf<JassVar>()
                d.param.forEach {
                    if (it.param) params.add(it)
                }
                val need = params.size

                val parenCtx = rParenCtx ?: lParenCtx

                if (exprs.size < need) {
                    Diagnostic(
                        range = Range.of(parenCtx) ?: Range.zero,
                        message = "No enought argument. Need $need, pass ${exprs.size}.",
                        code = ERROR,
                    ).also {
                        state.diagnostic.add(it)
                    }
                }

                for ((index, it) in exprs.withIndex()) {
                    val ectx = exprsCtx[index]
                    if (it == null) {
                        Diagnostic(
                            range = Range.of(ectx) ?: Range.zero,
                            message = "Unknown expression",
                            code = ERROR,
                        ).also {
                            state.diagnostic.add(it)
                        }
                        continue
                    }

                    if (index >= need) {
                        Diagnostic(
                            range = Range.of(exprsCtx[index]) ?: Range.zero,
                            message = "Redudant argument. Need $need, pass ${exprs.size}.",
                            code = ERROR,
                        ).also {
                            state.diagnostic.add(it)
                        }
                        continue
                    }
                    f.arg.add(it)
                    /*
                                        val ta = params.getOrNull(index)?.type ?: JassUndefinedType()
                                        val tb = it.type
                                        if (tb is JassNullType) continue


                                        if (ta.op(JassExprOp.Set, tb) is JassUndefinedType) {
                                            state.diagnosticHub.add(
                                                ectx,
                                                ERROR,
                                                "Wrong type. Need ${ta.name}, pass ${tb.name}."
                                            )
                                        }

                                         */
                }
            }

            return f
        }
    }
}
