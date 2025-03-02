package io.github.warraft.language.jass.antlr.psi

import io.github.warraft.JassParser.ExtendsRuleContext
import io.github.warraft.JassParser.TypeContext
import io.github.warraft.lsp.data.semantic.SemanticTokenModifier
import io.github.warraft.lsp.data.semantic.SemanticTokenType
import io.github.warraft.language.jass.antlr.psi.JassTypeName.Companion.BOOLEAN
import io.github.warraft.language.jass.antlr.psi.JassTypeName.Companion.CODE
import io.github.warraft.language.jass.antlr.psi.JassTypeName.Companion.HANDLE
import io.github.warraft.language.jass.antlr.psi.JassTypeName.Companion.INTEGER
import io.github.warraft.language.jass.antlr.psi.JassTypeName.Companion.REAL
import io.github.warraft.language.jass.antlr.psi.JassTypeName.Companion.STRING
import io.github.warraft.language.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.language.jass.antlr.state.JassState
import io.github.warraft.language.jass.lsp.diagnostic.JassDiagnosticCode.ERROR
import io.github.warraft.language.jass.lsp.diagnostic.JassDiagnosticCode.PLUGIN
import io.github.warraft.lsp.data.Diagnostic
import io.github.warraft.lsp.data.DiagnosticRelatedInformation
import io.github.warraft.lsp.data.DiagnosticSeverity
import io.github.warraft.lsp.data.Location
import io.github.warraft.lsp.data.Range
import org.antlr.v4.runtime.tree.TerminalNode

class JassType(override val state: JassState) : JassNodeBase() {
    var base: String? = null

    companion object {
        fun part(ctx: TerminalNode?, state: JassState): JassType? {
            val name = ctx?.text ?: return null

            val type = JassType(state).also {
                it.name = name
                it.symbol = ctx.symbol
                state.typeScope.add(it)
            }

            if (JassTypeName.isBase(name)) {
                type.type = JassTypeName(name)
            } else for (s in state.states + state) {
                val d = s.typeScope.definition(type) ?: continue
                type.also {
                    it.type = d.type
                    it.base = d.base
                }
                break
            }

            if (type.type == null) {
                Diagnostic(
                    range = Range.of(ctx) ?: Range.zero,
                    message = "Type $name is not defined",
                    severity = DiagnosticSeverity.Error,
                    code = ERROR.name
                ).also {
                    state.diagnosticHub.add(it)
                }
                type.type = JassTypeName(JassTypeName.UNDEFINED)
            }

            return type.also {
                state.typeScope.add(it)
                state.tokenTree.add(it)
            }
        }

        fun definition(ctx: TypeContext, state: JassState) {
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
                        Diagnostic(
                            range = Range.of(idCtx) ?: Range.zero,
                            severity = DiagnosticSeverity.Error,
                            code = ERROR.name,
                            message = "Type redeclared",
                        ).also {
                            it.relatedInformation(d, "First declaration of '${d.name}' is here")
                            state.diagnosticHub.add(it)
                        }
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

            type.also {
                state.typeScope.add(it, true)
                state.tokenTree.add(it)
            }
        }
    }
}
