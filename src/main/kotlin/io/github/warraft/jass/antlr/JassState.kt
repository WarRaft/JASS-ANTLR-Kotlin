package io.github.warraft.jass.antlr

import io.github.warraft.jass.antlr.JassParser.*
import io.github.warraft.jass.antlr.psi.*
import io.github.warraft.jass.lsp4j.diagnostic.JassDiagnosticCode
import io.github.warraft.jass.lsp4j.diagnostic.JassDiagnosticHub
import io.github.warraft.jass.lsp4j.folding.JassFoldingHub
import io.github.warraft.jass.lsp4j.semantic.JassSemanticTokenHub
import io.github.warraft.jass.lsp4j.semantic.JassSemanticTokenModifier
import io.github.warraft.jass.lsp4j.semantic.JassSemanticTokenType
import io.github.warraft.jass.lsp4j.symbol.JassDocumentSymbolHub
import org.antlr.v4.runtime.*
import org.antlr.v4.runtime.atn.ATNConfigSet
import org.antlr.v4.runtime.dfa.DFA
import org.antlr.v4.runtime.misc.Pair
import org.antlr.v4.runtime.tree.TerminalNode
import org.eclipse.lsp4j.CompletionItem
import org.eclipse.lsp4j.CompletionItemKind
import org.eclipse.lsp4j.Diagnostic
import org.eclipse.lsp4j.DiagnosticSeverity
import org.eclipse.lsp4j.DocumentSymbol
import org.eclipse.lsp4j.InsertTextFormat
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.Range
import org.eclipse.lsp4j.SymbolKind
import org.eclipse.lsp4j.jsonrpc.messages.Either
import java.util.*

class JassState {
    var states: List<JassState> = listOf()

    val typeMap: MutableMap<String, JassHandleType> = mutableMapOf()
    val types: MutableList<JassHandleType> = mutableListOf()

    val natives: MutableList<JassFun> = mutableListOf()
    val globals: MutableList<JassVar> = mutableListOf()
    val functions: MutableList<JassFun> = mutableListOf()

    val nodeMap: MutableMap<String, IJassNode> = mutableMapOf()

    val semanticHub = JassSemanticTokenHub()
    val foldingHub = JassFoldingHub()
    val diagnosticHub = JassDiagnosticHub()
    val documentSymbolHub = JassDocumentSymbolHub()

    fun parse(stream: CharStream, states: List<JassState> = listOf()) {
        this.states = states

        types.clear()
        typeMap.clear()
        natives.clear()
        globals.clear()
        functions.clear()
        nodeMap.clear()

        semanticHub.clear()
        foldingHub.clear()
        diagnosticHub.clear()
        documentSymbolHub.clear()

        val errorJassErrorListener = JassErrorListener()

        val lexer = JassLexer(stream)
        lexer.removeErrorListeners()
        lexer.addErrorListener(errorJassErrorListener)
        val f = JassTokenFactory()
        lexer.tokenFactory = f

        val tokens = CommonTokenStream(lexer)

        val parser = JassParser(tokens)
        parser.removeErrorListeners()
        parser.addErrorListener(errorJassErrorListener)
        root(parser.root())

        for (c in f.comments) {
            semanticHub.add(c, JassSemanticTokenType.COMMENT)
        }

        diagnosticHub.diagnostics.addAll(errorJassErrorListener.diagnostics)
    }

    fun getNode(key: String, f: JassFun?): IJassNode? {
        if (f != null) {
            for (p in f.param.asReversed()) {
                if (p.name == key) return p
            }
        }
        states.forEach {
            if (it.nodeMap.containsKey(key)) {
                return it.nodeMap[key]
            }
        }
        if (nodeMap.containsKey(key)) {
            return nodeMap[key]
        }
        return null
    }

    fun getType(key: String): IJassType? {
        var type: IJassType? = null
        states.forEach {
            if (it.typeMap.containsKey(key)) {
                type = it.typeMap[key]
            }
        }
        if (typeMap.containsKey(key)) {
            type = typeMap[key]
        }
        return type

    }

    fun typeFromString(str: String): IJassType = when (str) {
        "integer" -> JassIntType()
        "real" -> JassRealType()
        "string" -> JassStrType()
        "boolean" -> JassBoolType()
        "code" -> JassCodeType()
        "handle" -> JassHandleType(str)
        else -> getType(str) ?: JassUndefinedType()
    }

    private fun typedef(ctx: TypeContext) {
        val ectx: ExtendsRuleContext? = ctx.extendsRule()
        val namectx = ectx?.typename()
        val idctx = ctx.typename().ID()

        val type = JassHandleType(idctx.text)

        semanticHub
            .add(idctx, JassSemanticTokenType.TYPE)
            .add(ectx?.typename()?.ID(), JassSemanticTokenType.TYPE)
            .add(ctx.TYPE(), JassSemanticTokenType.KEYWORD)
            .add(ectx?.EXTENDS(), JassSemanticTokenType.KEYWORD)

        if (namectx == null) return

        val parent = namectx.text
        var p = typeMap[parent]
        if (parent == "handle" && p == null) {
            p = JassHandleType("handle")
            typeMap[parent] = p
            types.add(p)
        }

        if (p == null) {
            diagnosticHub.add(
                ctx.TYPE(),
                JassDiagnosticCode.ERROR,
                "${type.name} !extend $parent"
            )
            return
        }

        type.parent = p
        typeMap[type.name] = type
        types.add(type)
    }

    private fun global(ctx: VariableContext) {
        val nctx = ctx.varname()?.ID()
        val tctx = ctx.typename()?.ID()
        val cctx = ctx.CONSTANT()
        val actx = ctx.ARRAY()
        val eqctx = ctx.EQ()

        semanticHub
            .add(nctx, JassSemanticTokenType.VARIABLE, JassSemanticTokenModifier.DECLARATION)
            .add(tctx, JassSemanticTokenType.TYPE)
            .add(cctx, JassSemanticTokenType.KEYWORD)
            .add(actx, JassSemanticTokenType.KEYWORD)
            .add(eqctx, JassSemanticTokenType.OPERATOR)


        val v = JassVar(
            name = nctx?.text ?: "",
            constant = cctx != null,
            array = actx != null,
            global = true,
            type = typeFromString(ctx.typename().text),
            ctx = ctx,
        )

        if (eqctx != null) {
            v.expr = expr(ctx.expr(), null)
            if (v.expr == null) {
                diagnosticHub.add(
                    eqctx,
                    JassDiagnosticCode.ERROR,
                    "${v.name} global set missing"
                )
            } else {
                val ta: IJassType = v.type
                val tb: IJassType = v.expr!!.type
                val t = ta.op(JassExprOp.Set, tb)
                if (t is JassUndefinedType) {
                    diagnosticHub.add(
                        ctx.EQ(),
                        JassDiagnosticCode.ERROR,
                        "${ta.name} + ${tb.name} is ${t.name}"
                    )
                }
            }
        }

        if (getNode(v.name, null) != null) {
            diagnosticHub.add(
                nctx,
                JassDiagnosticCode.ERROR,
                "redeclared"
            )
            return
        }

        nodeMap[v.name] = v
        globals.add(v)
    }

    fun expr(
        ctx: ParserRuleContext,
        a: ExprContext?,
        b: ExprContext?,
        ops: List<TerminalNode?>,
        scope: JassFun?,
    ): JassExpr? {
        var op: JassExprOp? = null
        var optext: String? = ""
        for (it in ops) {
            semanticHub.add(it, JassSemanticTokenType.OPERATOR)
            optext = it?.text
            op = JassExprOp.fromSymbol(optext)
            if (op != null) break
        }

        if (op == null) {
            diagnosticHub.add(a ?: b, JassDiagnosticCode.PLUGIN, "Missing operator")
            return null
        }

        val e = JassExpr(
            op = op,
            a = expr(a, scope),
            b = expr(b, scope)
        )

        if (e.type is JassUndefinedType) {
            diagnosticHub.add(
                ctx,
                JassDiagnosticCode.ERROR,
                "Operation not exists: (${a?.text})->${e.a?.type?.name} $optext (${b?.text})->${e.b?.type?.name}"
            )
        }

        return e
    }

    fun expr(ctx: ExprContext?, scope: JassFun?): JassExpr? {
        if (ctx == null) return null

        when (ctx) {
            is ExprFunContext -> {
                val idctx = ctx.ID()
                val name = idctx.text
                val cf = JassFun(
                    name = name,
                    type = JassCodeType(),
                    ref = true,
                )

                semanticHub
                    .add(idctx, JassSemanticTokenType.FUNCTION)
                    .add(ctx.FUNCTION(), JassSemanticTokenType.KEYWORD)

                return JassExpr(
                    op = JassExprOp.Get,
                    a = cf
                )
            }

            is ExprCallContext -> {
                val idctx = ctx.ID()
                val name = idctx.text
                val node = getNode(name, scope)
                if (node !is JassFun) {
                    diagnosticHub.add(
                        idctx,
                        JassDiagnosticCode.ERROR,
                        "$name function not exists"
                    )
                    return null
                }
                val cf = node.clone()

                semanticHub.add(idctx, JassSemanticTokenType.FUNCTION)

                ctx.expr().forEach {
                    val e = expr(it, scope)
                    if (e != null) {
                        cf.arg.add(e)
                    }
                }

                return JassExpr(
                    op = JassExprOp.Get,
                    a = cf
                )
            }

            is ExprVarContext -> {
                val idctx = ctx.ID()
                semanticHub.add(idctx, JassSemanticTokenType.VARIABLE)
                val name = idctx.text
                var node: IJassNode? = getNode(name, scope)
                if (node is JassVar) {
                    return JassExpr(op = JassExprOp.Get, a = node.clone())
                }
                diagnosticHub.add(
                    idctx,
                    JassDiagnosticCode.ERROR,
                    "$name is not declared"
                )
                return null
            }

            is ExprArrContext -> {
                val idctx = ctx.ID()
                semanticHub.add(idctx, JassSemanticTokenType.VARIABLE)

                val name = idctx.text
                var node: IJassNode? = getNode(name, scope)
                if (node !is JassVar) {
                    diagnosticHub.add(
                        idctx,
                        JassDiagnosticCode.ERROR,
                        "$name array is not declared"
                    )
                    return null
                }
                return JassExpr(
                    op = JassExprOp.Get,
                    a = node.clone(
                        index = expr(ctx.expr(), scope)
                    )
                )
            }

            is ExprUnContext -> return JassExpr(
                op = when (true) {
                    (ctx.MINUS() != null) -> JassExprOp.UnSub
                    (ctx.NOT() != null) -> JassExprOp.UnNot
                    else -> return null
                },
                a = expr(ctx.expr(), scope),
            )

            is ExprIntContext -> {
                semanticHub
                    .add(ctx.INTVAL(), JassSemanticTokenType.NUMBER)
                    .add(ctx.HEXVAL(), JassSemanticTokenType.NUMBER)
                    .add(ctx.RAWVAL(), JassSemanticTokenType.NUMBER)
                return JassExpr(op = JassExprOp.Get, a = JassInt(ctx.text))
            }

            is ExprStrContext -> {
                semanticHub.add(ctx.STRING(), JassSemanticTokenType.STRING)
                return JassExpr(op = JassExprOp.Get, a = JassStr(ctx.text))
            }

            is ExprBoolContext -> {
                semanticHub
                    .add(ctx.TRUE(), JassSemanticTokenType.KEYWORD)
                    .add(ctx.FALSE(), JassSemanticTokenType.KEYWORD)
                return JassExpr(op = JassExprOp.Get, a = JassBool(ctx.text))
            }

            is ExprRealContext -> {
                semanticHub.add(ctx.REALVAL(), JassSemanticTokenType.NUMBER)
                return JassExpr(op = JassExprOp.Get, a = JassReal(ctx.text))
            }

            is ExprNullContext -> {
                semanticHub.add(ctx.NULL(), JassSemanticTokenType.KEYWORD)
                return JassExpr(op = JassExprOp.Get, a = JassNull())
            }

            is ExprParenContext -> return JassExpr(op = JassExprOp.Paren, a = expr(ctx.expr(), scope))

            is ExprMulContext -> return expr(
                ctx,
                ctx.expr(0),
                ctx.expr(1),
                listOf(ctx.MUL(), ctx.DIV()),
                scope
            )

            is ExprAddContext -> return expr(
                ctx,
                ctx.expr(0),
                ctx.expr(1),
                listOf(ctx.PLUS(), ctx.MINUS()),
                scope
            )

            is ExprLtContext -> return expr(
                ctx,
                ctx.expr(0),
                ctx.expr(1),
                listOf(ctx.LT(), ctx.LT_EQ(), ctx.GT(), ctx.GT_EQ()),
                scope
            )

            is ExprEqContext -> return expr(
                ctx,
                ctx.expr(0),
                ctx.expr(1),
                listOf(ctx.EQ_EQ(), ctx.NEQ()),
                scope
            )

            is ExprAndContext -> return expr(
                ctx,
                ctx.expr(0),
                ctx.expr(1),
                listOf(ctx.AND(), ctx.OR()),
                scope
            )
        }
        diagnosticHub.add(JassDiagnosticCode.PLUGIN, "Undeclared expression")
        return null
    }

    fun stmt(ctxs: List<StmtContext>, list: MutableList<IJassNode>, scopes: MutableList<IJassNode>) {
        val f = scopes.first() as JassFun

        for (ctx in ctxs) {
            when (ctx) {
                is StmtSetContext -> {
                    val setctx: SetContext = ctx.set()
                    val idctx = setctx.ID()
                    val name = idctx.text
                    var node = getNode(name, f)

                    semanticHub
                        .add(idctx, JassSemanticTokenType.VARIABLE)
                        .add(setctx.SET(), JassSemanticTokenType.KEYWORD)
                        .add(setctx.EQ(), JassSemanticTokenType.OPERATOR)


                    if (node !is JassVar) {
                        diagnosticHub.add(
                            idctx,
                            JassDiagnosticCode.ERROR,
                            "Varaible not exists"
                        )
                        continue
                    }

                    val e = expr(setctx.expr(), f)
                    if (e == null) {
                        diagnosticHub.add(
                            setctx.SET(),
                            JassDiagnosticCode.ERROR,
                            "Missing expression"
                        )
                        continue
                    }

                    list.add(
                        node.clone(
                            expr = e,
                            index = expr(setctx.setBrack()?.expr(), f),
                            ctx = ctx,
                        )
                    )
                    continue
                }

                is StmtCallContext -> {
                    val callctx: CallContext = ctx.call()
                    val idctx: TerminalNode? = callctx.ID()

                    semanticHub
                        .add(idctx, JassSemanticTokenType.FUNCTION)
                        .add(callctx.CALL(), JassSemanticTokenType.KEYWORD)

                    if (idctx == null) {
                        //err(JassErrorId.ERROR, JassToken(ctx), "Function name is missing")
                        continue
                    }

                    val name = idctx.text
                    var node = getNode(name, f)

                    var cf = JassFun(
                        call = true,
                        name = name
                    )

                    when (node) {
                        is JassFun -> cf = node.clone(call = true)
                        null -> {
                            diagnosticHub.add(
                                idctx,
                                JassDiagnosticCode.ERROR,
                                "Function not exists"
                            )
                        }

                        else -> {
                            diagnosticHub.add(
                                idctx,
                                JassDiagnosticCode.ERROR,
                                "Target is not a function"
                            )
                        }
                    }

                    semanticHub
                        .add(idctx, JassSemanticTokenType.FUNCTION)
                        .add(callctx.DEBUG(), JassSemanticTokenType.KEYWORD)
                        .add(callctx.CALL(), JassSemanticTokenType.KEYWORD)

                    callctx.expr().forEach {
                        val e = expr(it, f)
                        if (e != null) {
                            cf.arg.add(e)
                        }
                    }

                    list.add(cf)
                }

                is StmtLoopContext -> {
                    val loopctx: LoopContext = ctx.loop()

                    semanticHub
                        .add(loopctx.LOOP(), JassSemanticTokenType.KEYWORD)
                        .add(loopctx.ENDLOOP(), JassSemanticTokenType.KEYWORD)

                    val l = JassLoop(ctx = loopctx)
                    list.add(l)
                    val ss = scopes.toMutableList()
                    ss.add(l)
                    stmt(loopctx.stmt(), l.stmt, ss)
                }

                is StmtExitWhenContext -> {
                    val ewhenctx: ExitwhenContext = ctx.exitwhen()

                    semanticHub.add(ewhenctx.EXITWHEN(), JassSemanticTokenType.KEYWORD)

                    val exp = expr(ewhenctx.expr(), f)
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

                is StmtReturnContext -> {
                    val rctx: ReturnRuleContext = ctx.returnRule()

                    semanticHub.add(rctx.RETURN(), JassSemanticTokenType.KEYWORD)

                    val e = expr(rctx.expr(), f)
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

                is StmtIfContext -> {
                    val ifcxt: IfRuleContext = ctx.ifRule()
                    val e = expr(ifcxt.expr(), f)
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

                    for (elseifctx: ElseifContext in ifcxt.elseif()) {
                        val e = expr(elseifctx.expr(), f)
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

                    val elsectx: ElseRuleContext? = ifcxt.elseRule()
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


    fun function(fctx: ParserRuleContext) {
        var idctx: TerminalNode? = null
        var takesCtx: TakesContext? = null
        var returnsCtx: ReturnsRuleContext? = null

        val f = JassFun()

        var sym: DocumentSymbol? = null

        when (fctx) {
            is NativeRuleContext -> {
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
                for (paramCtx in takesCtx.params().param()) {
                    val namectx = paramCtx.varname().ID()
                    val typeCtx = paramCtx.typename().ID()

                    documentSymbolHub.add(paramCtx, namectx, SymbolKind.Variable, sym).apply {
                        this?.detail = typeCtx.text
                    }

                    semanticHub
                        .add(typeCtx, JassSemanticTokenType.TYPE_PARAMETER)
                        .add(
                            namectx,
                            JassSemanticTokenType.PARAMETER,
                            JassSemanticTokenModifier.DECLARATION
                        )

                    f.param.add(
                        JassVar(
                            name = paramCtx.varname().text,
                            type = typeFromString(paramCtx.typename().text),
                            local = true,
                            param = true,
                            ctx = paramCtx,
                        )
                    )
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
                val vnamectx: VarnameContext? = vctx.varname()
                if (vnamectx == null) {
                    continue
                }

                val name = vnamectx.text

                semanticHub
                    .add(vctx.CONSTANT(), JassSemanticTokenType.KEYWORD)
                    .add(vctx.ARRAY(), JassSemanticTokenType.KEYWORD)
                    .add(vctx.LOCAL(), JassSemanticTokenType.KEYWORD)
                    .add(vnamectx.ID(), JassSemanticTokenType.PARAMETER, JassSemanticTokenModifier.DECLARATION)
                    .add(vctx.typename().ID(), JassSemanticTokenType.TYPE, JassSemanticTokenModifier.DECLARATION)

                val v = JassVar(
                    name = name,
                    array = vctx.ARRAY() != null,
                    type = typeFromString(vctx.typename().text),
                    local = true,
                    ctx = vctx,
                )

                if (vctx.EQ() != null) {
                    v.expr = expr(vctx.expr(), f)
                    if (v.expr == null) {
                        diagnosticHub.add(vnamectx.ID(), JassDiagnosticCode.ERROR, "Missing expression")
                    }
                }

                f.param.add(v)
            }
        }

        val params = mutableMapOf<String, JassVar>()
        for (p in f.param.asReversed()) {
            val base = params[p.name]
            if (base == null) {
                params[p.name] = p
            } else {
                p.base = base
            }
        }

        if (fctx is FunctionContext) {
            stmt(fctx.stmt(), f.stmt, mutableListOf(f))
        }
    }

    fun root(ctx: RootContext): IJassNode? {
        ctx.children.forEach {
            when (it) {
                is GlobalsContext -> {
                    val sgctx = it.GLOBALS()
                    val egctx = it.ENDGLOBALS()


                    foldingHub.add(sgctx, egctx)
                    semanticHub
                        .add(sgctx, JassSemanticTokenType.KEYWORD)
                        .add(egctx, JassSemanticTokenType.KEYWORD)
                    it.variable().forEach(::global)
                }

                is TypeContext -> typedef(it)
                is NativeRuleContext -> function(it)
                is FunctionContext -> function(it)
            }
        }
        return null
    }


    fun completion(): List<CompletionItem> {
        val list = mutableListOf<CompletionItem>()

        fun type(t: String) {
            list.add(CompletionItem(t).apply {
                kind = CompletionItemKind.TypeParameter
                detail = "type"
            })
        }
        listOf("integer", "real", "boolean", "handle", "code").forEach { type(it) }

        fun function(f: JassFun) {
            list.add(CompletionItem(f.name).apply {
                kind = CompletionItemKind.Variable
                detail = "function"
                insertText = "${f.name}()"
                insertTextFormat = InsertTextFormat.PlainText
            })
        }

        fun get(state: JassState) {
            for (g in state.types) type(g.name)
            for (g in state.globals) {
                list.add(CompletionItem(g.name).apply {
                    kind = CompletionItemKind.Variable
                    detail = "global"
                })
            }
            for (f in state.natives) function(f)
            for (f in state.functions) function(f)
        }

        for (state in states) get(state)
        get(this)

        return list
    }

    companion object {
        private class JassTokenFactory : CommonTokenFactory() {
            val comments = mutableListOf<CommonToken>()

            override fun create(
                source: Pair<TokenSource?, CharStream?>?,
                type: Int,
                text: String?,
                channel: Int,
                start: Int,
                stop: Int,
                line: Int,
                charPositionInLine: Int,
            ): CommonToken? {
                var t = super.create(source, type, text, channel, start, stop, line, charPositionInLine)
                if (t.channel == 2) {
                    comments.add(t)
                }
                return t
            }
        }

        private class JassErrorListener : BaseErrorListener() {
            val diagnostics = mutableListOf<Diagnostic>()

            override fun syntaxError(
                recognizer: Recognizer<*, *>?,
                offendingSymbol: Any?,
                line: Int,
                charPositionInLine: Int,
                msg: String?,
                e: RecognitionException?,
            ) {
                diagnostics.add(
                    Diagnostic(
                        Range(Position(line - 1, charPositionInLine), Position(line - 1, charPositionInLine + 1)),
                        msg ?: "Uknown error",
                        DiagnosticSeverity.Error,
                        "",
                        JassDiagnosticCode.SYNTAX.name
                    )
                )
            }

            override fun reportAmbiguity(
                recognizer: Parser?,
                dfa: DFA?,
                startIndex: Int,
                stopIndex: Int,
                exact: Boolean,
                ambigAlts: BitSet?,
                configs: ATNConfigSet?,
            ) {
            }

            override fun reportAttemptingFullContext(
                recognizer: Parser?,
                dfa: DFA?,
                startIndex: Int,
                stopIndex: Int,
                conflictingAlts: BitSet?,
                configs: ATNConfigSet?,
            ) {
            }

            override fun reportContextSensitivity(
                recognizer: Parser?,
                dfa: DFA?,
                startIndex: Int,
                stopIndex: Int,
                prediction: Int,
                configs: ATNConfigSet?,
            ) {
            }
        }
    }
}
