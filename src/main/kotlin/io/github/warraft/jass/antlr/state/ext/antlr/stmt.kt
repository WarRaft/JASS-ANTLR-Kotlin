package io.github.warraft.jass.antlr.state.ext.antlr

import io.github.warraft.JassParser.*
import io.github.warraft.jass.antlr.psi.*
import io.github.warraft.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.jass.antlr.state.JassState
import io.github.warraft.jass.lsp4j.diagnostic.JassDiagnosticCode
import io.github.warraft.languages.lsp4j.service.document.semantic.token.SemanticTokenType
import org.antlr.v4.runtime.tree.TerminalNode

fun JassState.stmt(ctxs: List<StmtContext>, list: MutableList<JassNodeBase>, function: JassFun) {
    for (ctx in ctxs) {
        when (ctx) {

            //region StmtSetContext
            is StmtSetContext -> {
                val nameCtx: TerminalNode? = ctx.ID()

                var node: JassNodeBase? = null
                if (nameCtx == null) {
                    diagnosticHub.add(ctx, JassDiagnosticCode.ERROR, "Variable name is missing")
                } else {
                    val name = nameCtx.text
                    node = getNode(name, function)
                    if (node !is JassVar) {
                        diagnosticHub.add(nameCtx, JassDiagnosticCode.ERROR, "Set must be a variable")
                    }
                }

                semanticHub
                    .add(nameCtx, SemanticTokenType.VARIABLE)
                    .add(ctx.SET(), SemanticTokenType.KEYWORD)
                    .add(ctx.EQ(), SemanticTokenType.OPERATOR)

                val exprCtx = ctx.expr()
                val e = expr(exprCtx, function)
                if (e == null) {
                    diagnosticHub.add(
                        ctx.SET(),
                        JassDiagnosticCode.ERROR,
                        "Missing expression"
                    )
                    continue
                }

                if (node is JassVar) {
                    val brack: SetBrackContext? = ctx.setBrack()
                    val eBrack = expr(brack?.expr(), function)

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
                }

                continue
            }
            //endregion

            is StmtCallContext -> {
                val nameCtx: TerminalNode? = ctx.ID()

                semanticHub
                    .add(nameCtx, SemanticTokenType.FUNCTION)
                    .add(ctx.CALL(), SemanticTokenType.KEYWORD)

                if (nameCtx == null) {
                    diagnosticHub.add(
                        ctx,
                        JassDiagnosticCode.ERROR,
                        "Function name is missing"
                    )
                    continue
                }

                val name = nameCtx.text
                var node = getNode(name, function)

                var fn = JassFun(
                    state = this,
                    call = true,
                    name = name
                )

                when (node) {
                    is JassFun -> fn = node.clone(
                        state = this,
                        call = true,
                        symbol = nameCtx.symbol
                    ).also { tokenTree.add(it) }

                    null -> {
                        diagnosticHub.add(
                            nameCtx,
                            JassDiagnosticCode.ERROR,
                            "Function not exists"
                        )
                    }

                    else -> {
                        diagnosticHub.add(
                            nameCtx,
                            JassDiagnosticCode.ERROR,
                            "Target is not a function"
                        )
                    }
                }

                semanticHub
                    .add(nameCtx, SemanticTokenType.FUNCTION)
                    .add(ctx.DEBUG(), SemanticTokenType.KEYWORD)
                    .add(ctx.CALL(), SemanticTokenType.KEYWORD)

                argument(fn, function, ctx.expr(), ctx.LPAREN(), ctx.RPAREN())

                list.add(fn)
            }

            is StmtLoopContext -> {
                semanticHub
                    .add(ctx.LOOP(), SemanticTokenType.KEYWORD)
                    .add(ctx.ENDLOOP(), SemanticTokenType.KEYWORD)

                val l = JassLoop()
                list.add(l)
                stmt(ctx.stmt(), l.stmt, function)
            }

            is StmtExitWhenContext -> {
                semanticHub.add(ctx.EXITWHEN(), SemanticTokenType.KEYWORD)

                val exp = expr(ctx.expr(), function)
                if (exp == null) {
                    diagnosticHub.add(
                        ctx.EXITWHEN(),
                        JassDiagnosticCode.ERROR,
                        "Missing expression"
                    )
                } else {
                    list.add(JassExitWhen(expr = exp))
                }
            }

            is StmtReturnContext -> {
                semanticHub.add(ctx.RETURN(), SemanticTokenType.KEYWORD)

                val e = expr(ctx.expr(), function)
                if (e != null) {
                    val v = e.a
                    if (v is JassVar) {
                        if (v.array) {
                            diagnosticHub.add(
                                ctx.RETURN(),
                                JassDiagnosticCode.ARRAY_RETURN,
                                "Array return"
                            )
                        }
                    }
                }
                list.add(JassReturn(expr = e))
            }

            is StmtIfContext -> {
                val e = expr(ctx.expr(), function)
                if (e == null) {
                    diagnosticHub.add(
                        ctx.IF(),
                        JassDiagnosticCode.ERROR,
                        "Missing expression"
                    )
                    continue
                }
                val nodeIf = JassIf(expr = e)

                semanticHub
                    .add(ctx.IF(), SemanticTokenType.KEYWORD)
                    .add(ctx.THEN(), SemanticTokenType.KEYWORD)
                    .add(ctx.ENDIF(), SemanticTokenType.KEYWORD)

                list.add(nodeIf)
                stmt(ctx.stmt(), nodeIf.stmt, function)

                for (elseifctx: ElseifContext in ctx.elseif()) {
                    val e = expr(elseifctx.expr(), function)
                    semanticHub
                        .add(elseifctx.ELSEIF(), SemanticTokenType.KEYWORD)
                        .add(elseifctx.THEN(), SemanticTokenType.KEYWORD)
                    if (e == null) {
                        diagnosticHub.add(
                            elseifctx.ELSEIF(),
                            JassDiagnosticCode.ERROR,
                            "Missing expression"
                        )
                        continue
                    }
                    val nodeElseif = JassIf(expr = e)
                    nodeIf.elseifs.add(nodeElseif)
                    stmt(elseifctx.stmt(), nodeElseif.stmt, function)
                }

                val elsectx: ElseRuleContext? = ctx.elseRule()
                if (elsectx != null) {
                    semanticHub.add(elsectx.ELSE(), SemanticTokenType.KEYWORD)
                    val elser = JassIf()
                    nodeIf.elser = elser
                    stmt(elsectx.stmt(), elser.stmt, function)
                }
            }

            else -> diagnosticHub.add(JassDiagnosticCode.PLUGIN, "Udeclared statement")
        }
    }
}
