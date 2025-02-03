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

fun JassState.function(fctx: ParserRuleContext) {
    var idctx: TerminalNode? = null
    var takesCtx: JassParser.TakesContext? = null
    var returnsCtx: JassParser.ReturnsRuleContext? = null

    val f = JassFun()

    var sym: DocumentSymbol? = null

    when (fctx) {
        is JassParser.NativeRuleContext -> {
            f.native = true

            idctx = fctx.ID()
            takesCtx = fctx.takes()
            returnsCtx = fctx.returnsRule()

            val nctx = fctx.NATIVE()

            if (idctx == null) diagnosticHub.add(
                nctx,
                JassDiagnosticCode.ERROR,
                "Native name is missing"
            )

            sym = documentSymbolHub.add(fctx, idctx, SymbolKind.Function)

            semanticHub
                .add(fctx.CONSTANT(), JassSemanticTokenType.KEYWORD)
                .add(nctx, JassSemanticTokenType.KEYWORD)

            tokenTree.add(f, idctx)
        }

        is FunctionContext -> {
            idctx = fctx.ID()
            takesCtx = fctx.takes()
            returnsCtx = fctx.returnsRule()

            val sfctx = fctx.FUNCTION()
            val efctx = fctx.ENDFUNCTION()

            if (idctx == null) diagnosticHub.add(
                sfctx,
                JassDiagnosticCode.ERROR,
                "Function name is missing"
            )

            foldingHub.add(sfctx, efctx)

            sym = documentSymbolHub.add(fctx, idctx, SymbolKind.Function)
            semanticHub
                .add(fctx.CONSTANT(), JassSemanticTokenType.KEYWORD)
                .add(sfctx, JassSemanticTokenType.KEYWORD)
                .add(efctx, JassSemanticTokenType.KEYWORD)
        }
    }

    if (idctx != null) {
        val name = idctx.text
        semanticHub.add(idctx, JassSemanticTokenType.FUNCTION, JassSemanticTokenModifier.DECLARATION)
        f.name = name
        if (getNode(name, f) != null) {
            diagnosticHub.add(
                idctx,
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

                    documentSymbolHub.add(paramCtx, nameCtx, SymbolKind.Variable, sym).apply {
                        this?.detail = typeCtx.text
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
                            name = nameCtx.text,
                            type = typeFromString(typeCtx.text),
                            local = true,
                            param = true,
                            symbol = nameCtx.symbol,
                        ).apply {
                            tokenTree.add(this)
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

    if (fctx is FunctionContext) {
        for (vctx: VariableContext in fctx.variable()) {
            val nameCtx: VarnameContext? = vctx.varname()
            if (nameCtx == null) continue

            val name = nameCtx.text

            semanticHub
                .add(vctx.CONSTANT(), JassSemanticTokenType.KEYWORD)
                .add(vctx.ARRAY(), JassSemanticTokenType.KEYWORD)
                .add(vctx.LOCAL(), JassSemanticTokenType.KEYWORD)
                .add(nameCtx.ID(), JassSemanticTokenType.PARAMETER, JassSemanticTokenModifier.DECLARATION)
                .add(vctx.typename().ID(), JassSemanticTokenType.TYPE, JassSemanticTokenModifier.DECLARATION)

            val v = JassVar(
                name = name,
                array = vctx.ARRAY() != null,
                type = typeFromString(vctx.typename().text),
                local = true,
                symbol = nameCtx.ID().symbol,
            ).apply {
                tokenTree.add(this)
            }

            if (vctx.EQ() != null) {
                v.expr = expr(vctx.expr(), f)
                if (v.expr == null) {
                    diagnosticHub.add(nameCtx.ID(), JassDiagnosticCode.ERROR, "Missing expression")
                }
            }

            f.param.add(v)
        }
    }

    paramSameNameFix(f)

    if (fctx is FunctionContext) {
        stmt(fctx.stmt(), f.stmt, mutableListOf(f))
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
