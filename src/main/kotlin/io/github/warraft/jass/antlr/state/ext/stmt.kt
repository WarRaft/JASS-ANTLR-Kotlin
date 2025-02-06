package io.github.warraft.jass.antlr.state.ext

import io.github.warraft.jass.antlr.JassParser
import io.github.warraft.jass.antlr.JassParser.StmtCallContext
import io.github.warraft.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.jass.antlr.psi.JassExitWhen
import io.github.warraft.jass.antlr.psi.JassExprOp
import io.github.warraft.jass.antlr.psi.JassFun
import io.github.warraft.jass.antlr.psi.JassIf
import io.github.warraft.jass.antlr.psi.JassLoop
import io.github.warraft.jass.antlr.psi.JassReturn
import io.github.warraft.jass.antlr.psi.JassUndefinedType
import io.github.warraft.jass.antlr.psi.JassVar
import io.github.warraft.jass.antlr.state.JassState
import io.github.warraft.jass.lsp4j.diagnostic.JassDiagnosticCode
import io.github.warraft.jass.lsp4j.semantic.JassSemanticTokenType
import org.antlr.v4.runtime.tree.TerminalNode

fun JassState.stmt(ctxs: List<JassParser.StmtContext>, list: MutableList<JassNodeBase>, scopes: MutableList<JassNodeBase>) {
    val scope = scopes.first() as JassFun

    for (ctx in ctxs) {
        when (ctx) {
            is JassParser.StmtSetContext -> {
                val setctx: JassParser.SetContext = ctx.set()
                val nameCtx: TerminalNode? = setctx.ID()

                var node: JassNodeBase? = null
                if (nameCtx == null) {
                    diagnosticHub.add(
                        setctx,
                        JassDiagnosticCode.ERROR,
                        "Variable name is missing"
                    )
                } else {
                    val name = nameCtx.text
                    node = getNode(name, scope)

                    if (node !is JassVar) {
                        diagnosticHub.add(
                            nameCtx,
                            JassDiagnosticCode.ERROR,
                            "Set must be a variable"
                        )
                    }
                }

                semanticHub
                    .add(nameCtx, JassSemanticTokenType.VARIABLE)
                    .add(setctx.SET(), JassSemanticTokenType.KEYWORD)
                    .add(setctx.EQ(), JassSemanticTokenType.OPERATOR)


                val exprCtx = setctx.expr()
                val e = expr(exprCtx, scope)
                if (e == null) {
                    diagnosticHub.add(
                        setctx.SET(),
                        JassDiagnosticCode.ERROR,
                        "Missing expression"
                    )
                    continue
                }

                if (node is JassVar) {
                    val v = node.clone(
                        state = this,
                        expr = e,
                        index = expr(setctx.setBrack()?.expr(), scope),
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

            is StmtCallContext -> {
                val callctx: JassParser.CallContext = ctx.call()
                val nameCtx: TerminalNode? = callctx.ID()

                semanticHub
                    .add(nameCtx, JassSemanticTokenType.FUNCTION)
                    .add(callctx.CALL(), JassSemanticTokenType.KEYWORD)

                if (nameCtx == null) {
                    diagnosticHub.add(
                        ctx,
                        JassDiagnosticCode.ERROR,
                        "Function name is missing"
                    )
                    continue
                }

                val name = nameCtx.text
                var node = getNode(name, scope)

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
                    .add(nameCtx, JassSemanticTokenType.FUNCTION)
                    .add(callctx.DEBUG(), JassSemanticTokenType.KEYWORD)
                    .add(callctx.CALL(), JassSemanticTokenType.KEYWORD)

                argument(fn, scope, callctx.expr(), callctx.LPAREN(), callctx.RPAREN())

                list.add(fn)
            }

            is JassParser.StmtLoopContext -> {
                val loopctx: JassParser.LoopContext = ctx.loop()

                semanticHub
                    .add(loopctx.LOOP(), JassSemanticTokenType.KEYWORD)
                    .add(loopctx.ENDLOOP(), JassSemanticTokenType.KEYWORD)

                val l = JassLoop(ctx = loopctx)
                list.add(l)
                val ss = scopes.toMutableList()
                ss.add(l)
                stmt(loopctx.stmt(), l.stmt, ss)
            }

            is JassParser.StmtExitWhenContext -> {
                val ewhenctx: JassParser.ExitwhenContext = ctx.exitwhen()

                semanticHub.add(ewhenctx.EXITWHEN(), JassSemanticTokenType.KEYWORD)

                val exp = expr(ewhenctx.expr(), scope)
                if (exp == null) {
                    diagnosticHub.add(
                        ewhenctx.EXITWHEN(),
                        JassDiagnosticCode.ERROR,
                        "Missing expression"
                    )
                } else {
                    list.add(
                        JassExitWhen(
                            expr = exp,
                            ctx = ewhenctx,
                        )
                    )
                }
            }

            is JassParser.StmtReturnContext -> {
                val rctx: JassParser.ReturnRuleContext = ctx.returnRule()

                semanticHub.add(rctx.RETURN(), JassSemanticTokenType.KEYWORD)

                val e = expr(rctx.expr(), scope)
                if (e != null) {
                    val v = e.a
                    if (v is JassVar) {
                        if (v.array) {
                            diagnosticHub.add(
                                rctx.RETURN(),
                                JassDiagnosticCode.ARRAY_RETURN,
                                "Array return"
                            )
                        }
                    }
                }
                list.add(
                    JassReturn(
                        expr = e,
                        ctx = rctx,
                    )
                )
            }

            is JassParser.StmtIfContext -> {
                val ifcxt: JassParser.IfRuleContext = ctx.ifRule()
                val e = expr(ifcxt.expr(), scope)
                if (e == null) {
                    diagnosticHub.add(
                        ifcxt.IF(),
                        JassDiagnosticCode.ERROR,
                        "Missing expression"
                    )
                    continue
                }
                val nodeIf = JassIf(expr = e, ctx = ifcxt)

                semanticHub
                    .add(ifcxt.IF(), JassSemanticTokenType.KEYWORD)
                    .add(ifcxt.THEN(), JassSemanticTokenType.KEYWORD)
                    .add(ifcxt.ENDIF(), JassSemanticTokenType.KEYWORD)

                list.add(nodeIf)
                val ss = scopes.toMutableList()
                ss.add(nodeIf)
                stmt(ifcxt.stmt(), nodeIf.stmt, ss)

                for (elseifctx: JassParser.ElseifContext in ifcxt.elseif()) {
                    val e = expr(elseifctx.expr(), scope)
                    semanticHub
                        .add(elseifctx.ELSEIF(), JassSemanticTokenType.KEYWORD)
                        .add(elseifctx.THEN(), JassSemanticTokenType.KEYWORD)
                    if (e == null) {
                        diagnosticHub.add(
                            elseifctx.ELSEIF(),
                            JassDiagnosticCode.ERROR,
                            "Missing expression"
                        )
                        continue
                    }
                    val nodeElseif = JassIf(expr = e, ctx = elseifctx)
                    nodeIf.elseifs.add(nodeElseif)
                    stmt(elseifctx.stmt(), nodeElseif.stmt, ss)
                }

                val elsectx: JassParser.ElseRuleContext? = ifcxt.elseRule()
                if (elsectx != null) {
                    semanticHub.add(elsectx.ELSE(), JassSemanticTokenType.KEYWORD)
                    val elser = JassIf(ctx = elsectx)
                    nodeIf.elser = elser
                    stmt(elsectx.stmt(), elser.stmt, ss)
                }
            }

            else -> diagnosticHub.add(JassDiagnosticCode.PLUGIN, "Udeclared statement")
        }
    }
}
