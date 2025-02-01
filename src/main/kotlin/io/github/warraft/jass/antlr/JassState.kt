package io.github.warraft.jass.antlr

import io.github.warraft.jass.antlr.JassParser.*
import io.github.warraft.jass.antlr.error.JassError
import io.github.warraft.jass.antlr.error.JassErrorId
import io.github.warraft.jass.antlr.psi.*
import io.github.warraft.jass.lsp4j.semantic.JassSemanticTokenHub
import io.github.warraft.jass.lsp4j.semantic.JassSemanticTokenModifier
import io.github.warraft.jass.lsp4j.semantic.JassSemanticTokenType
import org.antlr.v4.runtime.*
import org.antlr.v4.runtime.atn.ATNConfigSet
import org.antlr.v4.runtime.dfa.DFA
import org.antlr.v4.runtime.misc.Pair
import org.antlr.v4.runtime.tree.TerminalNode
import java.util.*

class JassState {

    var states: List<JassState> = listOf()

    val typeMap: MutableMap<String, JassHandleType> = mutableMapOf()
    val types: MutableList<JassHandleType> = mutableListOf()

    val natives: MutableList<JassFun> = mutableListOf()
    val globals: MutableList<JassVar> = mutableListOf()
    val functions: MutableList<JassFun> = mutableListOf()

    val nodeMap: MutableMap<String, IJassNode> = mutableMapOf()

    @Deprecated("Shit")
    val errors = mutableListOf<JassError>()

    val semanticHub = JassSemanticTokenHub()

    fun parse(stream: CharStream, states: List<JassState> = listOf()) {
        this.states = states

        types.clear()
        typeMap.clear()
        natives.clear()
        globals.clear()
        functions.clear()
        nodeMap.clear()
        errors.clear()
        semanticHub.clear()

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

        if (errorJassErrorListener.jassErrors.isNotEmpty()) {
            errors.addAll(errorJassErrorListener.jassErrors)
        }
    }

    fun err(
        id: JassErrorId,
        message: String,
    ) {
        errors.add(
            JassError(
                id = id,
                message = message
            )
        )
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
        val parent = ctx.extendsRule().typename().text

        val type = JassHandleType(
            ctx.typename().text,
            ctx = ctx
        )

        var p = typeMap[parent]
        if (parent == "handle" && p == null) {
            p = JassHandleType("handle")
            typeMap[parent] = p
            types.add(p)
        }

        if (p == null) {
            errors.add(JassError(JassErrorId.TYPE_DEF, ctx.start.line, 0, "${type.name} !extend $parent"))
            return
        }

        type.parent = p
        typeMap[type.name] = type
        types.add(type)
    }

    private fun global(ctx: VariableContext) {
        val v = JassVar(
            name = ctx.varname().text,
            constant = ctx.CONSTANT() != null,
            array = ctx.ARRAY() != null,
            global = true,
            type = typeFromString(ctx.typename().text),
            ctx = ctx,
        )

        if (ctx.EQ() != null) {
            v.expr = expr(ctx.expr(), null)
            if (v.expr == null) {
                errors.add(JassError(JassErrorId.ERROR, ctx.start.line, 0, "⚠️ ${v.name} global set missing"))
            } else {
                val ta: IJassType = v.type
                val tb: IJassType = v.expr!!.type
                val t = ta.op(JassExprOp.Set, tb)
                if (t is JassUndefinedType) {
                    errors.add(JassError(JassErrorId.TYPE_CAST, ctx.start.line, 0, "$ta ${JassExprOp.Set} $tb is $t"))
                }
            }
        }

        if (getNode(v.name, null) != null) {
            errors.add(JassError(JassErrorId.REDECLARED, ctx.start.line, 0, v.name))
            return
        }

        nodeMap[v.name] = v
        globals.add(v)
    }

    fun expr(ctx: ExprContext?, f: JassFun?): JassExpr? {
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
                val node = getNode(name, f)
                if (node !is JassFun) {
                    errors.add(JassError(JassErrorId.ERROR, ctx.start.line, 0, "[call] $name is not a function"))
                    return null
                }
                val cf = node.clone()

                semanticHub.add(idctx, JassSemanticTokenType.FUNCTION)

                ctx.expr().forEach {
                    val e = expr(it, f)
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
                var node: IJassNode? = getNode(name, f)
                if (node is JassVar) {
                    return JassExpr(op = JassExprOp.Get, a = node.clone())
                }

                errors.add(JassError(JassErrorId.ERROR, ctx.start.line, 0, "$name is not declared"))
                return null
            }

            is ExprArrContext -> {
                val idctx = ctx.ID()
                semanticHub.add(idctx, JassSemanticTokenType.VARIABLE)

                val name = idctx.text
                var node: IJassNode? = getNode(name, f)
                if (node !is JassVar) {
                    errors.add(JassError(JassErrorId.ERROR, ctx.start.line, 0, "$name array is not declared"))
                    return null
                }
                return JassExpr(
                    op = JassExprOp.Get,
                    a = node.clone(
                        index = expr(ctx.expr(), f)
                    )
                )
            }

            is ExprUnContext -> return JassExpr(
                op = when (true) {
                    (ctx.MINUS() != null) -> JassExprOp.UnSub
                    (ctx.NOT() != null) -> JassExprOp.UnNot
                    else -> return null
                },
                a = expr(ctx.expr(), f),
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
                semanticHub.add(ctx.REALVAL(), JassSemanticTokenType.KEYWORD)
                return JassExpr(op = JassExprOp.Get, a = JassReal(ctx.text))
            }

            is ExprNullContext -> {
                semanticHub.add(ctx.NULL(), JassSemanticTokenType.KEYWORD)
                return JassExpr(op = JassExprOp.Get, a = JassNull())
            }

            is ExprParenContext -> return JassExpr(op = JassExprOp.Paren, a = expr(ctx.expr(), f))

            // 3
            is ExprMulContext -> return JassExpr(
                op = when (true) {
                    (ctx.MUL() != null) -> JassExprOp.Mul
                    (ctx.DIV() != null) -> JassExprOp.Div
                    else -> return null
                },
                a = expr(ctx.expr(0), f),
                b = expr(ctx.expr(1), f)
            )

            // 4
            is ExprAddContext -> return JassExpr(
                op = when (true) {
                    (ctx.PLUS() != null) -> JassExprOp.Add
                    (ctx.MINUS() != null) -> JassExprOp.Sub
                    else -> return null
                },
                a = expr(ctx.expr(0), f),
                b = expr(ctx.expr(1), f)
            )

            // 5
            is ExprLtContext -> return JassExpr(
                op = when (true) {
                    (ctx.LT() != null) -> JassExprOp.Lt
                    (ctx.LT_EQ() != null) -> JassExprOp.LtEq
                    (ctx.GT() != null) -> JassExprOp.Gt
                    (ctx.GT_EQ() != null) -> JassExprOp.GtEq
                    else -> return null
                },
                a = expr(ctx.expr(0), f),
                b = expr(ctx.expr(1), f)
            )

            // 6
            is ExprEqContext -> return JassExpr(
                op = when (true) {
                    (ctx.EQ_EQ() != null) -> JassExprOp.Eq
                    (ctx.NEQ() != null) -> JassExprOp.Neq
                    else -> return null
                },
                a = expr(ctx.expr(0), f),
                b = expr(ctx.expr(1), f)
            )

            // 7
            is ExprAndContext -> return JassExpr(
                op = when (true) {
                    (ctx.AND() != null) -> JassExprOp.And
                    (ctx.OR() != null) -> JassExprOp.Or
                    else -> return null
                },
                a = expr(ctx.expr(0), f),
                b = expr(ctx.expr(1), f)
            )
        }
        errors.add(JassError(JassErrorId.ERROR, ctx.start.line, 0, "Undeclared expression"))
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

                    if (node !is JassVar) {
                        errors.add(JassError(JassErrorId.ERROR, setctx.start.line, 0, "[set] $name not exists"))
                        continue
                    }

                    val e = expr(setctx.expr(), f)
                    if (e == null) {
                        errors.add(
                            JassError(
                                JassErrorId.ERROR,
                                setctx.start.line,
                                0,
                                "[set] $name no have expression"
                            )
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
                        .add(idctx, JassSemanticTokenType.VARIABLE)
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
                        //null -> err(JassErrorId.ERROR_CALL_NOT_EXISTS, JassToken(idctx), "Function not exists")
                        //else -> err(JassErrorId.ERROR_CALL_NOT_FUNC, JassToken(idctx), "Target is not a function")
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
                        errors.add(JassError(JassErrorId.ERROR, ewhenctx.start.line, 0, "exitwhen without expression"))
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
                                errors.add(JassError(JassErrorId.RETURN_ARRAY, rctx.start.line, 0, "return array"))
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
                        errors.add(JassError(JassErrorId.ERROR, ifcxt.start.line, 0, "[if] not have expr"))
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
                        val e = expr(ifcxt.expr(), f)
                        semanticHub
                            .add(elseifctx.ELSEIF(), JassSemanticTokenType.KEYWORD)
                            .add(elseifctx.THEN(), JassSemanticTokenType.KEYWORD)
                        if (e == null) {
                            errors.add(JassError(JassErrorId.ERROR, ifcxt.start.line, 0, "[elseif] not have expr"))
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

                else -> {
                    errors.add(JassError(JassErrorId.REDECLARED, ctx.start.line, 0, "Udeclared statement"))
                }
            }
        }
    }

    fun function(fctx: ParserRuleContext) {
        var idctx: TerminalNode? = null
        var tctx: TakesContext? = null
        var rctx: ReturnsRuleContext? = null

        val f = JassFun()

        when (fctx) {
            is NativeRuleContext -> {
                f.native = true

                idctx = fctx.ID()
                tctx = fctx.takes()
                rctx = fctx.returnsRule()

                semanticHub
                    .add(fctx.CONSTANT(), JassSemanticTokenType.KEYWORD)
                    .add(fctx.NATIVE(), JassSemanticTokenType.KEYWORD)
            }

            is FunctionContext -> {
                idctx = fctx.ID()
                tctx = fctx.takes()
                rctx = fctx.returnsRule()

                semanticHub
                    .add(fctx.CONSTANT(), JassSemanticTokenType.KEYWORD)
                    .add(fctx.FUNCTION(), JassSemanticTokenType.KEYWORD)
                    .add(fctx.ENDFUNCTION(), JassSemanticTokenType.KEYWORD)
            }
        }

        if (idctx == null) {
            //err(JassErrorId.ERROR, f.token.sort().keywords.firstOrNull(), "Function name is missing")
        } else {
            val name = idctx.text
            semanticHub.add(idctx, JassSemanticTokenType.FUNCTION, JassSemanticTokenModifier.DECLARATION)
            f.name = name
            if (getNode(name, f) != null) {
                //err(JassErrorId.ERROR_FUN_REDECLARED, f.token.name, "Function name redeclared: ${f.name}")
            }
            nodeMap[name] = f
        }

        if (f.native) natives.add(f)
        else functions.add(f)

        if (tctx != null) {
            val nctx = tctx.NOTHING()
            semanticHub
                .add(nctx, JassSemanticTokenType.KEYWORD)
                .add(tctx.TAKES(), JassSemanticTokenType.KEYWORD)

            if (nctx == null) {
                for (vctx in tctx.params().param()) {
                    semanticHub
                        .add(vctx.typename().ID(), JassSemanticTokenType.TYPE)
                        .add(
                            vctx.varname().ID(),
                            JassSemanticTokenType.PARAMETER,
                            JassSemanticTokenModifier.DECLARATION
                        )

                    f.param.add(
                        JassVar(
                            name = vctx.varname().text,
                            type = typeFromString(vctx.typename().text),
                            local = true,
                            param = true,
                            ctx = vctx,
                        )
                    )
                }
            }
        }

        if (rctx != null) {
            val nctx = rctx.NOTHING()
            semanticHub
                .add(nctx, JassSemanticTokenType.KEYWORD)
                .add(rctx.RETURNS(), JassSemanticTokenType.KEYWORD)

            if (nctx == null) {
                val idctx: TerminalNode? = rctx.ID()
                if (idctx != null) {
                    f.type = typeFromString(idctx.text)

                    if (f.type is JassUndefinedType) err(
                        JassErrorId.ERROR_TYPE_UNKNOWN,
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
                        errors.add(
                            JassError(
                                JassErrorId.ERROR,
                                fctx.start.line,
                                0,
                                "${f.name} variable without expression"
                            )
                        )
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
                    semanticHub
                        .add(it.GLOBALS(), JassSemanticTokenType.KEYWORD)
                        .add(it.ENDGLOBALS(), JassSemanticTokenType.KEYWORD)
                    it.variable().forEach(::global)
                }

                is TypeContext -> typedef(it)
                is NativeRuleContext -> function(it)
                is FunctionContext -> function(it)
            }
        }
        return null
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
            val jassErrors = mutableListOf<JassError>()

            override fun syntaxError(
                recognizer: Recognizer<*, *>?,
                offendingSymbol: Any?,
                line: Int,
                charPositionInLine: Int,
                msg: String?,
                e: RecognitionException?,
            ) {
                jassErrors.add(
                    JassError(
                        id = JassErrorId.ERROR_SYNTAX,
                        message = msg ?: "Syntax error",
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
