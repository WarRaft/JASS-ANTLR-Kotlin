package io.github.warraft.jass.antlr.state.ext

import io.github.warraft.jass.antlr.JassParser
import io.github.warraft.jass.antlr.JassParser.FunctionContext
import io.github.warraft.jass.antlr.JassParser.VariableContext
import io.github.warraft.jass.antlr.JassParser.VarnameContext
import io.github.warraft.jass.antlr.psi.JassFun
import io.github.warraft.jass.antlr.psi.JassUndefinedType
import io.github.warraft.jass.antlr.psi.JassVar
import io.github.warraft.jass.antlr.state.JassState
import io.github.warraft.jass.lsp4j.diagnostic.JassDiagnosticCode
import io.github.warraft.jass.lsp4j.semantic.JassSemanticTokenModifier
import io.github.warraft.jass.lsp4j.semantic.JassSemanticTokenType
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.TerminalNode
import org.eclipse.lsp4j.DocumentSymbol
import org.eclipse.lsp4j.SymbolKind
import kotlin.collections.set

fun JassState.function(funCtx: ParserRuleContext) {
    var nameCtx: TerminalNode? = null
    var takesCtx: JassParser.TakesContext? = null
    var returnsCtx: JassParser.ReturnsRuleContext? = null

    val f = JassFun(
        state = this
    )

    var sym: DocumentSymbol? = null

    when (funCtx) {
        is JassParser.NativeRuleContext -> {
            f.native = true

            nameCtx = funCtx.ID()
            takesCtx = funCtx.takes()
            returnsCtx = funCtx.returnsRule()

            val nctx = funCtx.NATIVE()

            if (nameCtx == null) diagnosticHub.add(
                nctx,
                JassDiagnosticCode.ERROR,
                "Native name is missing"
            )

            sym = documentSymbolHub.add(funCtx, nameCtx, SymbolKind.Function)

            semanticHub
                .add(funCtx.CONSTANT(), JassSemanticTokenType.KEYWORD)
                .add(nctx, JassSemanticTokenType.KEYWORD)

            tokenTree.add(f, nameCtx)
        }

        is FunctionContext -> {
            nameCtx = funCtx.ID()
            takesCtx = funCtx.takes()
            returnsCtx = funCtx.returnsRule()

            val sfctx = funCtx.FUNCTION()
            val efctx = funCtx.ENDFUNCTION()

            if (nameCtx == null) diagnosticHub.add(
                sfctx,
                JassDiagnosticCode.ERROR,
                "Function name is missing"
            )

            foldingHub.add(sfctx, efctx)

            sym = documentSymbolHub.add(funCtx, nameCtx, SymbolKind.Function)
            semanticHub
                .add(funCtx.CONSTANT(), JassSemanticTokenType.KEYWORD)
                .add(sfctx, JassSemanticTokenType.KEYWORD)
                .add(efctx, JassSemanticTokenType.KEYWORD)
        }
    }

    if (nameCtx != null) {
        tokenTree.add(f.apply { symbol = nameCtx.symbol })

        val name = nameCtx.text
        semanticHub.add(nameCtx, JassSemanticTokenType.FUNCTION, JassSemanticTokenModifier.DECLARATION)
        f.name = name
        if (getNode(name, f) != null) {
            diagnosticHub.add(
                nameCtx,
                JassDiagnosticCode.ERROR,
                "Function name redeclared: ${f.name}"
            )
        }
        nodeMap[name] = f
    }

    if (f.native) natives.add(f)
    else functions.add(f)

    if (takesCtx != null) {
        val nctx = takesCtx.NOTHING()
        semanticHub
            .add(nctx, JassSemanticTokenType.KEYWORD)
            .add(takesCtx.TAKES(), JassSemanticTokenType.KEYWORD)

        if (nctx == null) {
            val paramsCtx: JassParser.ParamsContext? = takesCtx.params()
            val paramCtx = paramsCtx?.param()

            if (paramCtx != null) {
                for (paramCtx in paramCtx) {
                    val nameCtx = paramCtx.varname().ID()
                    val typeCtx = paramCtx.typename().ID()

                    documentSymbolHub.add(paramCtx, nameCtx, SymbolKind.Variable, sym).also {
                        it?.detail = typeCtx.text
                    }

                    semanticHub
                        .add(typeCtx, JassSemanticTokenType.TYPE_PARAMETER)
                        .add(
                            nameCtx,
                            JassSemanticTokenType.PARAMETER,
                            JassSemanticTokenModifier.DECLARATION
                        )

                    f.param.add(
                        JassVar(
                            state = this,
                            name = nameCtx.text,
                            type = typeFromString(typeCtx.text),
                            local = true,
                            param = true,
                            symbol = nameCtx.symbol,
                        ).also {
                            tokenTree.add(it)
                        }
                    )
                }
            }
        }
    }

    if (returnsCtx != null) {
        val nctx = returnsCtx.NOTHING()
        semanticHub
            .add(nctx, JassSemanticTokenType.KEYWORD)
            .add(returnsCtx.RETURNS(), JassSemanticTokenType.KEYWORD)

        if (nctx == null) {
            val idctx: TerminalNode? = returnsCtx.ID()
            if (idctx != null) {
                semanticHub.add(idctx, JassSemanticTokenType.TYPE)
                sym?.detail = idctx.text

                f.type = typeFromString(idctx.text)
                if (f.type is JassUndefinedType) diagnosticHub.add(
                    idctx,
                    JassDiagnosticCode.ERROR,
                    "Unknown type: ${idctx.text}"
                )
            }
        }
    }

    if (funCtx is FunctionContext) {
        for (vctx: VariableContext in funCtx.variable()) {
            val varnameCtx: VarnameContext? = vctx.varname()
            val nameCtx = varnameCtx?.ID()
            if (nameCtx == null) continue

            val name = nameCtx.text

            semanticHub
                .add(vctx.CONSTANT(), JassSemanticTokenType.KEYWORD)
                .add(vctx.ARRAY(), JassSemanticTokenType.KEYWORD)
                .add(vctx.LOCAL(), JassSemanticTokenType.KEYWORD)
                .add(nameCtx, JassSemanticTokenType.PARAMETER, JassSemanticTokenModifier.DECLARATION)
                .add(vctx.typename().ID(), JassSemanticTokenType.TYPE, JassSemanticTokenModifier.DECLARATION)

            val v = JassVar(
                state = this,
                name = name,
                array = vctx.ARRAY() != null,
                type = typeFromString(vctx.typename().text),
                local = true,
                symbol = nameCtx.symbol,
            ).also {
                tokenTree.add(it)
            }

            if (vctx.EQ() != null) {
                v.expr = expr(vctx.expr(), f)
                if (v.expr == null) {
                    diagnosticHub.add(nameCtx, JassDiagnosticCode.ERROR, "Missing expression")
                }
            }

            f.param.add(v)
        }
    }

    paramSameNameFix(f)

    if (funCtx is FunctionContext) {
        stmt(funCtx.stmt(), f.stmt, mutableListOf(f))
    }
}

private fun paramSameNameFix(f: JassFun) {
    val params = mutableMapOf<String, JassVar>()
    for (p in f.param.asReversed()) {
        p.links.clear()
        val base = params[p.name]
        if (base == null) {
            params[p.name] = p
        } else {
            p.base = base
            base.links.add(p)
        }
    }
}
