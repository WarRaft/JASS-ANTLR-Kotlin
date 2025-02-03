package io.github.warraft.jass.antlr.state

import io.github.warraft.jass.antlr.JassLexer
import io.github.warraft.jass.antlr.JassParser
import io.github.warraft.jass.antlr.psi.*
import io.github.warraft.jass.antlr.state.ext.expr
import io.github.warraft.jass.antlr.state.ext.function
import io.github.warraft.jass.antlr.utils.JassErrorListener
import io.github.warraft.jass.antlr.utils.JassTokenFactory
import io.github.warraft.jass.antlr.utils.JassTokenTree
import io.github.warraft.jass.lsp4j.diagnostic.JassDiagnosticCode
import io.github.warraft.jass.lsp4j.diagnostic.JassDiagnosticHub
import io.github.warraft.jass.lsp4j.folding.JassFoldingHub
import io.github.warraft.jass.lsp4j.semantic.JassSemanticTokenHub
import io.github.warraft.jass.lsp4j.semantic.JassSemanticTokenModifier
import io.github.warraft.jass.lsp4j.semantic.JassSemanticTokenType
import io.github.warraft.jass.lsp4j.symbol.JassDocumentSymbolHub
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CommonTokenStream

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
    val tokenTree = JassTokenTree()

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
        tokenTree.clear()

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

    private fun typedef(ctx: JassParser.TypeContext) {
        val ectx: JassParser.ExtendsRuleContext? = ctx.extendsRule()
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

    private fun global(ctx: JassParser.VariableContext) {
        val nameCtx = ctx.varname()?.ID()
        val tctx = ctx.typename()?.ID()
        val cctx = ctx.CONSTANT()
        val actx = ctx.ARRAY()
        val eqctx = ctx.EQ()

        semanticHub
            .add(nameCtx, JassSemanticTokenType.VARIABLE, JassSemanticTokenModifier.DECLARATION)
            .add(tctx, JassSemanticTokenType.TYPE)
            .add(cctx, JassSemanticTokenType.KEYWORD)
            .add(actx, JassSemanticTokenType.KEYWORD)
            .add(eqctx, JassSemanticTokenType.OPERATOR)


        val v = JassVar(
            name = nameCtx?.text ?: "",
            constant = cctx != null,
            array = actx != null,
            global = true,
            type = typeFromString(ctx.typename().text),
            symbol = nameCtx?.symbol
        ).apply {
            tokenTree.add(this)
        }

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
                nameCtx,
                JassDiagnosticCode.ERROR,
                "redeclared"
            )
            return
        }

        nodeMap[v.name] = v
        globals.add(v)
    }

    fun root(ctx: JassParser.RootContext): IJassNode? {
        ctx.children.forEach {
            when (it) {
                is JassParser.GlobalsContext -> {
                    val sgctx = it.GLOBALS()
                    val egctx = it.ENDGLOBALS()


                    foldingHub.add(sgctx, egctx)
                    semanticHub
                        .add(sgctx, JassSemanticTokenType.KEYWORD)
                        .add(egctx, JassSemanticTokenType.KEYWORD)
                    it.variable().forEach(::global)
                }

                is JassParser.TypeContext -> typedef(it)
                is JassParser.NativeRuleContext -> function(it)
                is JassParser.FunctionContext -> function(it)
            }
        }
        return null
    }

}
