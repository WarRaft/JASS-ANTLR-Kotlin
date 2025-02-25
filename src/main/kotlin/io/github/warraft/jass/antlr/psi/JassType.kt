package io.github.warraft.jass.antlr.psi

import io.github.warraft.JassParser.ExtendsRuleContext
import io.github.warraft.JassParser.TypeContext
import io.github.warraft.jass.antlr.psi.JassTypeName.Companion.BOOLEAN
import io.github.warraft.jass.antlr.psi.JassTypeName.Companion.CODE
import io.github.warraft.jass.antlr.psi.JassTypeName.Companion.HANDLE
import io.github.warraft.jass.antlr.psi.JassTypeName.Companion.INTEGER
import io.github.warraft.jass.antlr.psi.JassTypeName.Companion.REAL
import io.github.warraft.jass.antlr.psi.JassTypeName.Companion.STRING
import io.github.warraft.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.jass.antlr.state.JassState
import io.github.warraft.jass.lsp4j.diagnostic.JassDiagnosticCode.ERROR
import io.github.warraft.jass.lsp4j.diagnostic.JassDiagnosticCode.PLUGIN
import io.github.warraft.languages.lsp4j.service.document.semantic.token.SemanticTokenModifier
import io.github.warraft.languages.lsp4j.service.document.semantic.token.SemanticTokenType
import io.github.warraft.languages.lsp4j.utils.DiagnosticRelatedInformationEx
import org.antlr.v4.runtime.tree.TerminalNode

class JassType(override val state: JassState) : JassNodeBase() {
    var base: String? = null

    companion object {
        fun parse(ctx: TypeContext, state: JassState) {
            val typeCtx: TerminalNode? = ctx.TYPE()
            val idCtx: TerminalNode? = ctx.ID()

            val extendsRuleCtx: ExtendsRuleContext? = ctx.extendsRule()
            val extendsCtx: TerminalNode? = extendsRuleCtx?.EXTENDS()
            val baseIdCtx: TerminalNode? = extendsRuleCtx?.ID()

            state.semanticHub
                .add(typeCtx, SemanticTokenType.KEYWORD)
                .add(extendsCtx, SemanticTokenType.KEYWORD)
                .add(idCtx, SemanticTokenType.TYPE, SemanticTokenModifier.DECLARATION)
                .add(baseIdCtx, SemanticTokenType.TYPE)

            if (idCtx == null) {
                state.diagnosticHub.add(ctx, ERROR, "Missing type name")
                return
            }

            if (baseIdCtx == null) {
                state.diagnosticHub.add(ctx, ERROR, "Missing base type")
                return
            }

            val type = JassType(state).also {
                it.name = idCtx.text
                it.type = JassTypeName(idCtx.text)
                it.symbol = idCtx.symbol
                it.definition = ctx
                it.base = baseIdCtx.text
            }

            when (type.name) {
                INTEGER,
                REAL,
                STRING,
                BOOLEAN,
                CODE,
                HANDLE,
                    -> {
                    state.diagnosticHub.add(idCtx, ERROR, "Base type redeclared")
                    return
                }

                else -> {
                    for (s in state.states + state) {
                        val d = s.typeScope.definition(type)
                        if (d == null) continue
                        state.diagnosticHub.add(
                            idCtx, ERROR, "Type redeclared",
                            listOf(DiagnosticRelatedInformationEx.get(d, "First declaration of '${d.name}' is here"))
                        )
                        return
                    }
                }
            }

            state.typeScope.add(JassType(state).also {
                it.name = type.base
                it.symbol = baseIdCtx.symbol
                state.tokenTree.add(it)
            })

            var typeBase = type.base
            var i = 0
            while (typeBase != HANDLE) {
                if (++i == 100) {
                    state.diagnosticHub.add(ctx, PLUGIN, "Many loops when type found")
                    break
                }
                var d: JassType? = null
                for (s in state.states + state) {
                    d = s.typeScope.definition(typeBase) ?: continue
                    typeBase = d.base
                }
                if (d == null) break
                if (typeBase == null) break
            }

            if (typeBase != HANDLE) {
                state.diagnosticHub.add(baseIdCtx, ERROR, "Base type not extends handle")
                return
            }

            state.typeScope.add(type.also {
                state.tokenTree.add(it)
            }, true)
        }
    }
}
