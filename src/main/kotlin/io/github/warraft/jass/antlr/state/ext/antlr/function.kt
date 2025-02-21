package io.github.warraft.jass.antlr.state.ext.antlr

import io.github.warraft.JassParser.*
import io.github.warraft.jass.antlr.psi.JassFun
import io.github.warraft.jass.antlr.psi.JassUndefinedType
import io.github.warraft.jass.antlr.psi.JassVar
import io.github.warraft.jass.antlr.state.JassState
import io.github.warraft.jass.lsp4j.diagnostic.JassDiagnosticCode
import io.github.warraft.languages.lsp4j.service.document.semantic.token.SemanticTokenModifier.DECLARATION
import io.github.warraft.languages.lsp4j.service.document.semantic.token.SemanticTokenModifier.DOCUMENTATION
import io.github.warraft.languages.lsp4j.service.document.semantic.token.SemanticTokenType
import io.github.warraft.languages.lsp4j.service.document.semantic.token.SemanticTokenType.COMMENT
import io.github.warraft.languages.lsp4j.service.document.semantic.token.SemanticTokenType.KEYWORD
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.TerminalNode
import org.eclipse.lsp4j.SymbolKind

fun JassState.function(defCtx: ParserRuleContext) {
    var nameCtx: TerminalNode? = null
    var takesCtx: TakesContext? = null
    var returnsCtx: ReturnsRuleContext? = null

    val function = JassFun(
        state = this
    )

    //region Comments
    val comments = mutableListOf<String>()
    for (i in defCtx.start.line - 1 downTo 0) {
        val t = commentsMap[i]
        if (t == null) break
        commentsMap.remove(i)
        comments.addFirst(t.text.replaceFirst("^//\\s?".toRegex(), ""))
        semanticHub.add(t, COMMENT, DOCUMENTATION)
    }
    for (c in comments) {
        function.comments.append(c).append("\n")
    }
    //endregion

    // === head
    when (defCtx) {
        //region NativeRuleContext
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
                .add(nativeCtx, KEYWORD)
                .add(defCtx.CONSTANT(), KEYWORD)
        }
        //endregion

        //region FunctionContext
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
                .add(defCtx.CONSTANT(), KEYWORD)
                .add(functionCtx, KEYWORD)
                .add(enfunctionCtx, KEYWORD)

            foldingHub.add(functionCtx, enfunctionCtx)
        }
        //endregion
    }


    //region Name
    if (nameCtx != null) {
        var name = nameCtx.text

        function.documentSymbol = documentSymbolHub.add(defCtx, nameCtx, SymbolKind.Function)

        tokenTree.add(function.also {
            it.symbol = nameCtx.symbol
            it.name = name
            it.definition = defCtx
        })

        semanticHub.add(nameCtx, SemanticTokenType.FUNCTION, DECLARATION)

        if (getNode(name, function) != null) {
            diagnosticHub.add(
                nameCtx,
                JassDiagnosticCode.ERROR,
                "Function name redeclared: ${function.name}"
            )
        }
        nodeMap[name] = function
    }
    //endregion

    //region Holder
    if (function.native) natives.add(function)
    else functions.add(function)
    //endregion

    //region Takes
    if (takesCtx != null) {
        val nothingCtx = takesCtx.NOTHING()
        semanticHub
            .add(nothingCtx, KEYWORD)
            .add(takesCtx.TAKES(), KEYWORD)

        if (nothingCtx == null) {
            for (ctx in takesCtx.param()) JassVar.parse(ctx, function, this)
        }
    }
    //endregion

    //region Returns
    if (returnsCtx != null) {
        val nothingCtx = returnsCtx.NOTHING()
        semanticHub
            .add(nothingCtx, KEYWORD)
            .add(returnsCtx.RETURNS(), KEYWORD)

        if (nothingCtx == null) {
            val idCtx: TerminalNode? = returnsCtx.ID()
            if (idCtx != null) {
                semanticHub.add(idCtx, SemanticTokenType.TYPE)
                function.documentSymbol?.detail = idCtx.text

                function.type = typeFromString(idCtx.text)
                if (function.type is JassUndefinedType) diagnosticHub.add(idCtx, JassDiagnosticCode.ERROR, "Unknown type: ${idCtx.text}")
            }
        }
    }
    //endregion

    //region Body
    if (defCtx !is FunctionContext) return
    for (ctx: VariableContext in defCtx.variable()) JassVar.parse(ctx, function, this)
    stmt(defCtx.stmt(), function.stmt, function)
    //endregion
}
