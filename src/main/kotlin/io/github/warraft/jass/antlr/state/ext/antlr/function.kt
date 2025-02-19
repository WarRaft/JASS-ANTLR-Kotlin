package io.github.warraft.jass.antlr.state.ext.antlr

import io.github.warraft.JassParser.*
import io.github.warraft.jass.antlr.psi.JassFun
import io.github.warraft.jass.antlr.psi.JassUndefinedType
import io.github.warraft.jass.antlr.psi.JassVar
import io.github.warraft.jass.antlr.psi.utils.JassVarScope
import io.github.warraft.jass.antlr.state.JassState
import io.github.warraft.jass.lsp4j.diagnostic.JassDiagnosticCode
import io.github.warraft.languages.lsp4j.service.document.semantic.token.SemanticTokenModifier
import io.github.warraft.languages.lsp4j.service.document.semantic.token.SemanticTokenType
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.TerminalNode
import org.eclipse.lsp4j.DocumentSymbol
import org.eclipse.lsp4j.SymbolKind
import kotlin.collections.set

fun JassState.function(defCtx: ParserRuleContext) {
    var nameCtx: TerminalNode? = null
    var takesCtx: TakesContext? = null
    var returnsCtx: ReturnsRuleContext? = null

    val function = JassFun(
        state = this
    ).also {
        it.scopeVar = JassVarScope(it)
    }

    // === comments
    val comments = mutableListOf<String>()
    for (i in defCtx.start.line - 1 downTo 0) {
        val t = commentsMap[i]
        if (t == null) break
        commentsMap.remove(i)
        comments.addFirst(t.text.replaceFirst("^//\\s?".toRegex(), ""))
        semanticHub.add(t, SemanticTokenType.COMMENT, SemanticTokenModifier.DOCUMENTATION)
    }
    for (c in comments) {
        function.comments.append(c).append("\n")
    }

    // === head
    when (defCtx) {
        is NativeRuleContext -> {
            function.native = true

            nameCtx = defCtx.ID()
            takesCtx = defCtx.takes()
            returnsCtx = defCtx.returnsRule()

            val nativeCtx = defCtx.NATIVE()
            if (nameCtx == null) diagnosticHub.add(
                nativeCtx,
                JassDiagnosticCode.ERROR,
                "Native name is missing"
            )

            semanticHub
                .add(nativeCtx, SemanticTokenType.KEYWORD)
                .add(defCtx.CONSTANT(), SemanticTokenType.KEYWORD)
        }

        is FunctionContext -> {
            nameCtx = defCtx.ID()
            takesCtx = defCtx.takes()
            returnsCtx = defCtx.returnsRule()

            val functionCtx = defCtx.FUNCTION()
            val enfunctionCtx = defCtx.ENDFUNCTION()

            if (nameCtx == null) diagnosticHub.add(
                functionCtx,
                JassDiagnosticCode.ERROR,
                "Function name is missing"
            )

            semanticHub
                .add(defCtx.CONSTANT(), SemanticTokenType.KEYWORD)
                .add(functionCtx, SemanticTokenType.KEYWORD)
                .add(enfunctionCtx, SemanticTokenType.KEYWORD)

            foldingHub.add(functionCtx, enfunctionCtx)
        }
    }

    var documentSymbol: DocumentSymbol? = null

    if (nameCtx != null) {
        var name = nameCtx.text

        documentSymbol = documentSymbolHub.add(defCtx, nameCtx, SymbolKind.Function)

        tokenTree.add(function.also {
            it.symbol = nameCtx.symbol
            it.name = name
            it.definition = defCtx
        })

        semanticHub.add(nameCtx, SemanticTokenType.FUNCTION, SemanticTokenModifier.DECLARATION)

        if (getNode(name, function) != null) {
            diagnosticHub.add(
                nameCtx,
                JassDiagnosticCode.ERROR,
                "Function name redeclared: ${function.name}"
            )
        }
        nodeMap[name] = function
    }

    if (function.native) natives.add(function)
    else functions.add(function)

    // === takes
    if (takesCtx != null) {
        val nothingCtx = takesCtx.NOTHING()
        semanticHub
            .add(nothingCtx, SemanticTokenType.KEYWORD)
            .add(takesCtx.TAKES(), SemanticTokenType.KEYWORD)

        if (nothingCtx == null) {
            for (paramCtx in takesCtx.param()) {
                val nameCtx = paramCtx.varname()?.ID()
                val typeCtx = paramCtx.typename()?.ID()
                if (nameCtx == null || typeCtx == null) continue

                documentSymbolHub.add(paramCtx, nameCtx, SymbolKind.Variable, documentSymbol).also {
                    it?.detail = typeCtx.text
                }

                semanticHub
                    .add(typeCtx, SemanticTokenType.TYPE_PARAMETER)
                    .add(
                        nameCtx,
                        SemanticTokenType.PARAMETER,
                        SemanticTokenModifier.DECLARATION
                    )

                function.param.add(
                    JassVar(
                        state = this,
                        name = nameCtx.text,
                        type = typeFromString(typeCtx.text),
                        local = true,
                        param = true,
                        symbol = nameCtx.symbol,
                    ).also {
                        tokenTree.add(it)
                        function.scopeVar?.definition(it)
                    }
                )
            }
        }
    }

    // === returns
    if (returnsCtx != null) {
        val nothingCtx = returnsCtx.NOTHING()
        semanticHub
            .add(nothingCtx, SemanticTokenType.KEYWORD)
            .add(returnsCtx.RETURNS(), SemanticTokenType.KEYWORD)

        if (nothingCtx == null) {
            val idCtx: TerminalNode? = returnsCtx.ID()
            if (idCtx != null) {
                semanticHub.add(idCtx, SemanticTokenType.TYPE)
                documentSymbol?.detail = idCtx.text

                function.type = typeFromString(idCtx.text)
                if (function.type is JassUndefinedType) diagnosticHub.add(idCtx, JassDiagnosticCode.ERROR, "Unknown type: ${idCtx.text}")
            }
        }
    }

    // === function body
    if (defCtx !is FunctionContext) return

    for (varDefCtx: VariableContext in defCtx.variable()) {
        val varnameCtx: VarnameContext? = varDefCtx.varname()
        val arrayCtx: TerminalNode? = varDefCtx.ARRAY()
        val nameCtx = varnameCtx?.ID()
        if (nameCtx == null) continue

        val name = nameCtx.text

        semanticHub
            .add(varDefCtx.CONSTANT(), SemanticTokenType.KEYWORD)
            .add(arrayCtx, SemanticTokenType.KEYWORD)
            .add(varDefCtx.LOCAL(), SemanticTokenType.KEYWORD)
            .add(nameCtx, SemanticTokenType.PARAMETER, SemanticTokenModifier.DECLARATION)
            .add(varDefCtx.typename().ID(), SemanticTokenType.TYPE, SemanticTokenModifier.DECLARATION)

        val v = JassVar(
            state = this,
            name = name,
            array = arrayCtx != null,
            type = typeFromString(varDefCtx.typename().text),
            local = true,
            symbol = nameCtx.symbol,
        ).also {
            tokenTree.add(it)
            function.scopeVar?.definition(it)
        }

        if (varDefCtx.EQ() != null) {
            v.expr = expr(varDefCtx.expr(), function)
            if (v.expr == null) {
                diagnosticHub.add(nameCtx, JassDiagnosticCode.ERROR, "Missing expression")
            }
        }

        function.param.add(v)
    }

    stmt(defCtx.stmt(), function.stmt, function)
}
