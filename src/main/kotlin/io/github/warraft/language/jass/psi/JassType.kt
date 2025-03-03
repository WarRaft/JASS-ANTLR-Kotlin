package io.github.warraft.language.jass.psi

import io.github.warraft.JassParser.ExtendsRuleContext
import io.github.warraft.JassParser.TypeContext
import io.github.warraft.lsp.data.semantic.SemanticTokenModifier
import io.github.warraft.lsp.data.semantic.SemanticTokenType
import io.github.warraft.language.jass.psi.JassTypeName.Companion.BOOLEAN
import io.github.warraft.language.jass.psi.JassTypeName.Companion.CODE
import io.github.warraft.language.jass.psi.JassTypeName.Companion.HANDLE
import io.github.warraft.language.jass.psi.JassTypeName.Companion.INTEGER
import io.github.warraft.language.jass.psi.JassTypeName.Companion.REAL
import io.github.warraft.language.jass.psi.JassTypeName.Companion.STRING
import io.github.warraft.language.jass.psi.base.JassNodeBase
import io.github.warraft.language.jass.state.JassState
import io.github.warraft.lsp.data.DiagnosticCode.ERROR
import io.github.warraft.lsp.data.DiagnosticCode.PLUGIN
import io.github.warraft.lsp.data.Diagnostic
import io.github.warraft.lsp.data.DiagnosticSeverity
import io.github.warraft.lsp.data.Range
import org.antlr.v4.runtime.tree.TerminalNode

class JassType(override val state: JassState) : JassNodeBase() {
    var base: String? = null

    override fun toString(): String = "JassType(name=$name, base=$base)"

    companion object {
        fun handleTree(s: String?, state: JassState): MutableList<String> {
            val out = mutableListOf<String>()
            if (s == null) return out

            out.add(s)

            var typeBase = s
            var i = 0
            while (typeBase != HANDLE) {
                if (++i == 100) {
                    state.server?.log("Many loops when type found")
                    break
                }
                var d: JassType? = null
                for (s in state.states + state) {
                    d = s.typeScope.definition(typeBase) ?: continue
                    typeBase = d.base
                }
                if (d == null) break
                if (typeBase == null) break
                out.add(typeBase)
            }

            return out
        }

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
                    code = ERROR
                ).also {
                    state.diagnostic.add(it)
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
                Diagnostic(
                    range = Range.of(ctx) ?: Range.zero,
                    message = "Missing type name",
                    code = ERROR,
                ).also {
                    state.diagnostic.add(it)
                }
                return
            }

            if (baseIdCtx == null) {
                Diagnostic(
                    range = Range.of(ctx) ?: Range.zero,
                    message = "Missing base type",
                    code = ERROR,
                ).also {
                    state.diagnostic.add(it)
                }
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
                    Diagnostic(
                        range = Range.of(idCtx) ?: Range.zero,
                        message = "Base type redeclared",
                        code = ERROR,
                    ).also {
                        state.diagnostic.add(it)
                    }
                    return
                }

                else -> {
                    for (s in state.states + state) {
                        val d = s.typeScope.definition(type)
                        if (d == null) continue
                        Diagnostic(
                            range = Range.of(idCtx) ?: Range.zero,
                            severity = DiagnosticSeverity.Error,
                            code = ERROR,
                            message = "Type redeclared",
                        ).also {
                            it.relatedInformation(d, "First declaration of '${d.name}' is here")
                            state.diagnostic.add(it)
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

            val typeBase = handleTree(type.base, state).lastOrNull()

            if (typeBase != HANDLE) {
                Diagnostic(
                    range = Range.of(ctx) ?: Range.zero,
                    message = "Base type not extends handle",
                    code = ERROR,
                ).also {
                    state.diagnostic.add(it)
                }
                return
            }

            type.also {
                state.typeScope.add(it, true)
                state.tokenTree.add(it)
            }
        }
    }
}
