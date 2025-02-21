package io.github.warraft.jass.antlr.psi

import io.github.warraft.JassParser.*
import io.github.warraft.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.jass.antlr.psi.base.JassTypeBase
import io.github.warraft.jass.antlr.state.JassState
import io.github.warraft.jass.antlr.state.ext.antlr.expr
import io.github.warraft.jass.antlr.state.ext.antlr.stmt
import io.github.warraft.jass.antlr.state.ext.antlr.typeFromString
import io.github.warraft.jass.lsp4j.diagnostic.JassDiagnosticCode.ERROR
import io.github.warraft.languages.lsp4j.service.document.semantic.token.SemanticTokenModifier.DECLARATION
import io.github.warraft.languages.lsp4j.service.document.semantic.token.SemanticTokenModifier.DOCUMENTATION
import io.github.warraft.languages.lsp4j.service.document.semantic.token.SemanticTokenType
import io.github.warraft.languages.lsp4j.service.document.semantic.token.SemanticTokenType.COMMENT
import io.github.warraft.languages.lsp4j.service.document.semantic.token.SemanticTokenType.KEYWORD
import io.github.warraft.languages.lsp4j.utils.DiagnosticRelatedInformationEx
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.tree.TerminalNode
import org.eclipse.lsp4j.DocumentSymbol
import org.eclipse.lsp4j.SymbolKind

class JassFun(
    val state: JassState,
    var name: String? = null,
    var native: Boolean = false,
    var ref: Boolean = false,
    override var type: JassTypeBase = JassUndefinedType(),
    var symbol: Token? = null,
    var definition: ParserRuleContext? = null,
) : JassNodeBase() {
    val varScope: JassVarScope = JassVarScope(
        state = state,
        function = this
    )
    lateinit var scope: JassFunScope

    var fakename: String = ""

    val param: MutableList<JassVar> = mutableListOf()
    val arg: MutableList<JassExpr> = mutableListOf()
    val stmt: MutableList<JassNodeBase> = mutableListOf()

    val comments = StringBuilder()

    var documentSymbol: DocumentSymbol? = null

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

            val f = JassFun(
                state = state
            )

            when (ctx) {
                is NativeRuleContext,
                is FunctionContext,
                    -> {
                    var takesCtx: TakesContext? = null
                    var returnsCtx: ReturnsRuleContext? = null

                    //region Comments
                    val comments = mutableListOf<String>()
                    for (i in ctx.start.line - 1 downTo 0) {
                        val t = state.commentsMap[i]
                        if (t == null) break
                        state.commentsMap.remove(i)
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
                            state
                                .diagnosticHub
                                .add(
                                    nameCtx, ERROR, "Function redeclared",
                                    listOf(DiagnosticRelatedInformationEx.get(d, "First declaration of '${d.name}' is here"))
                                )
                        }

                        state.funScope.add(f, true)
                    }
                    //endregion

                    //region Holder
                    if (f.native) state.natives.add(f)
                    else state.functions.add(f)
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

                                f.type = state.typeFromString(idCtx.text)
                                if (f.type is JassUndefinedType) state.diagnosticHub.add(idCtx, ERROR, "Unknown type: ${idCtx.text}")
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
                        it.type = JassCodeType()
                        it.ref = true
                    }
                }
            }

            val exprs = mutableListOf<JassExpr>()
            if (exprsCtx != null) for (ectx in exprsCtx) {
                val e = state.expr(ectx, function) ?: continue
                exprs.add(e)
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

            }

            /*
            val root: JassFun? = if (fn.base == null) null else fn.root

            val params = mutableListOf<JassVar>()
            root?.param?.forEach {
                if (it.param) params.add(it)
            }
            val need = params.size

            val paren = rp ?: lp

            if (root != null && exprs.size < need) {
                diagnosticHub.add(
                    paren,
                    JassDiagnosticCode.ERROR,
                    "No enought argument. Need $need, pass ${exprs.size}."
                )
            }

            for ((index, it) in exprs.withIndex()) {
                val e = expr(it, scope) ?: continue
                if (index >= need) {
                    diagnosticHub.add(
                        it,
                        JassDiagnosticCode.ERROR,
                        "Redudant argument. Need $need, pass ${exprs.size}."
                    )
                    continue
                }
                fn.arg.add(e)

                val a = params.getOrNull(index)?.type ?: JassUndefinedType()
                val b = e.type
                if (b is JassNullType) continue

                if (a.op(JassExprOp.Set, b) is JassUndefinedType) {
                    diagnosticHub.add(
                        it,
                        JassDiagnosticCode.ERROR,
                        "Wrong type. Need ${a.name}, pass ${b.name}."
                    )
                }
            }
             */


            return f
        }
    }
}
