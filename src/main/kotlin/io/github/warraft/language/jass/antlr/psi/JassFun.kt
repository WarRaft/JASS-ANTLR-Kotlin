package io.github.warraft.language.jass.antlr.psi

import io.github.warraft.JassParser.*
import io.github.warraft.lsp.data.semantic.SemanticTokenModifier.DECLARATION
import io.github.warraft.lsp.data.semantic.SemanticTokenModifier.DOCUMENTATION
import io.github.warraft.lsp.data.semantic.SemanticTokenType
import io.github.warraft.lsp.data.semantic.SemanticTokenType.COMMENT
import io.github.warraft.lsp.data.semantic.SemanticTokenType.KEYWORD
import io.github.warraft.language.jass.antlr.psi.JassTypeName.Companion.CODE
import io.github.warraft.language.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.language.jass.antlr.state.JassState
import io.github.warraft.language.jass.antlr.state.ext.antlr.stmt
import io.github.warraft.language.jass.lsp.diagnostic.JassDiagnosticCode.ERROR
import io.github.warraft.lsp.data.Diagnostic
import io.github.warraft.lsp.data.DiagnosticRelatedInformation
import io.github.warraft.lsp.data.DiagnosticSeverity
import io.github.warraft.lsp.data.DocumentSymbol
import io.github.warraft.lsp.data.Location
import io.github.warraft.lsp.data.Range
import io.github.warraft.lsp.data.SymbolKind
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
                            if (nameCtx == null) state.diagnosticHub.add(nativeCtx, ERROR, "Native name is missing")

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

                            if (nameCtx == null) state.diagnosticHub.add(functionCtx, ERROR, "Function name is missing")

                            state.semanticHub
                                .add(ctx.CONSTANT(), KEYWORD)
                                .add(functionCtx, KEYWORD)
                                .add(enfunctionCtx, KEYWORD)

                            state.foldingHub.add(functionCtx, enfunctionCtx)
                        }
                        //endregion
                    }


                    //region Name
                    if (nameCtx != null) {
                        var name = nameCtx.text

                        f.documentSymbol = state.documentSymbolHub.add(ctx, nameCtx, SymbolKind.Function)

                        state.tokenTree.add(f.also {
                            it.symbol = nameCtx.symbol
                            it.name = name
                            it.definition = ctx
                        })

                        state.semanticHub.add(nameCtx, SemanticTokenType.FUNCTION, DECLARATION)

                        for (s in state.states + state) {
                            val d = s.funScope.definition(f)
                            if (d == null) continue
                            Diagnostic(
                                range = Range.of(nameCtx) ?: Range.zero,
                                severity = DiagnosticSeverity.Error,
                                code = ERROR.name,
                                message = "Function redeclared",
                            ).also {
                                it.relatedInformation(d, "First declaration of '${d.name}' is here")
                                state.diagnosticHub.add(it)
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
                            val idCtx: TerminalNode? = returnsCtx.ID()
                            if (idCtx != null) {
                                state.semanticHub.add(idCtx, SemanticTokenType.TYPE)
                                f.documentSymbol?.detail = idCtx.text

                                //f.type = state.typeFromString(idCtx.text)
                                //if (f.type is JassUndefinedType) state.diagnosticHub.add(idCtx, ERROR, "Unknown type: ${idCtx.text}")
                            }
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
                state.diagnosticHub.add(ctx, ERROR, "Function name is missing")
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

            if (d == null) state.diagnosticHub.add(nameCtx, ERROR, "Function not exists")
            else if (exprsCtx != null) {
                f.also {
                    it.type = d.type
                }

                val params = mutableListOf<JassVar>()
                d.param.forEach {
                    if (it.param) params.add(it)
                }
                val need = params.size

                val paren = rParenCtx ?: lParenCtx

                if (exprs.size < need) {
                    state.diagnosticHub.add(paren, ERROR, "No enought argument. Need $need, pass ${exprs.size}.")
                }

                for ((index, it) in exprs.withIndex()) {
                    val ectx = exprsCtx[index]
                    if (it == null) {
                        state.diagnosticHub.add(ectx, ERROR, "Unknown expression")
                        continue
                    }

                    if (index >= need) {
                        state.diagnosticHub.add(exprsCtx[index], ERROR, "Redudant argument. Need $need, pass ${exprs.size}.")
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
