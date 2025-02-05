package io.github.warraft.jass.antlr.state.ext

import io.github.warraft.jass.antlr.JassParser
import io.github.warraft.jass.antlr.JassParser.FunctionContext
import io.github.warraft.jass.antlr.JassParser.NativeRuleContext
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

fun JassState.function(defCtx: ParserRuleContext) {
    var nameCtx: TerminalNode? = null
    var takesCtx: JassParser.TakesContext? = null
    var returnsCtx: JassParser.ReturnsRuleContext? = null

    val f = JassFun(
        state = this
    )

    val comments = mutableListOf<String>()
    for (i in defCtx.start.line - 1 downTo 0) {
        val t = commentsMap[i]
        if (t == null) break
        commentsMap.remove(i)
        comments.addFirst(t.text.replaceFirst("^//\\s?".toRegex(), ""))
        semanticHub.add(t, JassSemanticTokenType.COMMENT, JassSemanticTokenModifier.DOCUMENTATION)
    }
    for (c in comments) {
        f.comments.append(c).append("\n")
    }

    var sym: DocumentSymbol? = null

    when (defCtx) {
        is NativeRuleContext -> {
            f.native = true

            nameCtx = defCtx.ID()
            takesCtx = defCtx.takes()
            returnsCtx = defCtx.returnsRule()

            val nctx = defCtx.NATIVE()

            if (nameCtx == null) diagnosticHub.add(
                nctx,
                JassDiagnosticCode.ERROR,
                "Native name is missing"
            )

            sym = documentSymbolHub.add(defCtx, nameCtx, SymbolKind.Function)

            semanticHub
                .add(defCtx.CONSTANT(), JassSemanticTokenType.KEYWORD)
                .add(nctx, JassSemanticTokenType.KEYWORD)

            tokenTree.add(f, nameCtx)
        }

        is FunctionContext -> {
            nameCtx = defCtx.ID()
            takesCtx = defCtx.takes()
            returnsCtx = defCtx.returnsRule()

            val sfctx = defCtx.FUNCTION()
            val efctx = defCtx.ENDFUNCTION()

            if (nameCtx == null) diagnosticHub.add(
                sfctx,
                JassDiagnosticCode.ERROR,
                "Function name is missing"
            )

            foldingHub.add(sfctx, efctx)

            sym = documentSymbolHub.add(defCtx, nameCtx, SymbolKind.Function)
            semanticHub
                .add(defCtx.CONSTANT(), JassSemanticTokenType.KEYWORD)
                .add(sfctx, JassSemanticTokenType.KEYWORD)
                .add(efctx, JassSemanticTokenType.KEYWORD)
        }
    }

    if (nameCtx != null) {
        var name = nameCtx.text

        tokenTree.add(f.also {
            it.symbol = nameCtx.symbol
            it.name = name
            it.definition = defCtx
        })

        semanticHub.add(nameCtx, JassSemanticTokenType.FUNCTION, JassSemanticTokenModifier.DECLARATION)

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
                            definition = paramsCtx,
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

    if (defCtx is FunctionContext) {
        for (varDefCtx: VariableContext in defCtx.variable()) {
            val varnameCtx: VarnameContext? = varDefCtx.varname()
            val nameCtx = varnameCtx?.ID()
            if (nameCtx == null) continue

            val name = nameCtx.text

            semanticHub
                .add(varDefCtx.CONSTANT(), JassSemanticTokenType.KEYWORD)
                .add(varDefCtx.ARRAY(), JassSemanticTokenType.KEYWORD)
                .add(varDefCtx.LOCAL(), JassSemanticTokenType.KEYWORD)
                .add(nameCtx, JassSemanticTokenType.PARAMETER, JassSemanticTokenModifier.DECLARATION)
                .add(varDefCtx.typename().ID(), JassSemanticTokenType.TYPE, JassSemanticTokenModifier.DECLARATION)

            val v = JassVar(
                state = this,
                name = name,
                array = varDefCtx.ARRAY() != null,
                type = typeFromString(varDefCtx.typename().text),
                local = true,
                symbol = nameCtx.symbol,
                definition = varDefCtx,
            ).also {
                tokenTree.add(it)
            }

            if (varDefCtx.EQ() != null) {
                v.expr = expr(varDefCtx.expr(), f)
                if (v.expr == null) {
                    diagnosticHub.add(nameCtx, JassDiagnosticCode.ERROR, "Missing expression")
                }
            }

            f.param.add(v)
        }
    }

    paramSameNameFix(f)

    if (defCtx is FunctionContext) {
        stmt(defCtx.stmt(), f.stmt, mutableListOf(f))
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
