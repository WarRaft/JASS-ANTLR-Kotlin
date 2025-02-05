package io.github.warraft.jass.antlr.state.ext

import io.github.warraft.jass.antlr.JassParser.TypeContext
import io.github.warraft.jass.antlr.psi.JassBoolType
import io.github.warraft.jass.antlr.psi.JassCodeType
import io.github.warraft.jass.antlr.psi.JassHandleType
import io.github.warraft.jass.antlr.psi.JassIntType
import io.github.warraft.jass.antlr.psi.JassRealType
import io.github.warraft.jass.antlr.psi.JassStrType
import io.github.warraft.jass.antlr.psi.JassUndefinedType
import io.github.warraft.jass.antlr.psi.base.JassTypeBase
import io.github.warraft.jass.antlr.state.JassState
import io.github.warraft.jass.lsp4j.diagnostic.JassDiagnosticCode
import io.github.warraft.jass.lsp4j.semantic.JassSemanticTokenModifier
import io.github.warraft.jass.lsp4j.semantic.JassSemanticTokenType

fun JassState.typeGet(key: String): JassTypeBase? {
    var type: JassTypeBase? = null
    states.forEach {
        if (it.typeMap.containsKey(key)) {
            type = it.typeMap[key]
        }
    }
    if (typeMap.containsKey(key)) {
        type = typeMap[key]
    }
    return type?.clone()

}

fun JassState.typeFromString(str: String): JassTypeBase = when (str) {
    "integer" -> JassIntType()
    "real" -> JassRealType()
    "string" -> JassStrType()
    "boolean" -> JassBoolType()
    "code" -> JassCodeType()
    else -> typeGet(str) ?: JassUndefinedType()
}

fun JassState.typedef(defCtx: TypeContext) {

    val keyCtx = defCtx.TYPE()
    semanticHub.add(keyCtx, JassSemanticTokenType.KEYWORD)

    val nameCtx = defCtx.ID()

    if (nameCtx == null) {
        diagnosticHub.add(
            keyCtx,
            JassDiagnosticCode.ERROR,
            "Missint type name",
        )
        return
    }

    val eKeyCtxt = defCtx.extendsRule()

    semanticHub
        .add(nameCtx, JassSemanticTokenType.TYPE, JassSemanticTokenModifier.DECLARATION)
        .add(eKeyCtxt.EXTENDS(), JassSemanticTokenType.KEYWORD)

    if (eKeyCtxt == null) {
        diagnosticHub.add(
            keyCtx,
            JassDiagnosticCode.ERROR,
            "missing extends rule",
        )
        return
    }

    val parentCtx = eKeyCtxt.ID()

    if (parentCtx == null) {
        diagnosticHub.add(
            eKeyCtxt,
            JassDiagnosticCode.ERROR,
            "Missing parent type",
        )
        return
    }

    val name = nameCtx.text
    var type = typeGet(name)
    if (type != null) {
        diagnosticHub.add(
            nameCtx,
            JassDiagnosticCode.ERROR,
            "Type redeclared"
        )
        return
    }


    val parentName = parentCtx.text

    var parent = typeGet(parentName)
    if (parentName == "handle" && parent == null) {
        parent = JassHandleType("handle")
        typeMap[parentName] = parent
        types.add(parent)
    }

    if (parent == null) {
        diagnosticHub.add(
            parentCtx,
            JassDiagnosticCode.ERROR,
            "Wrong extend"
        )
        return
    }

    if (parent !is JassHandleType) {
        diagnosticHub.add(
            parentCtx,
            JassDiagnosticCode.ERROR,
            "Can't find extend no handle",
        )
        return
    }

    type = JassHandleType(
        name = name,
        parent = parent,
    )

    parent.childrens.add(type)

    typeMap[type.name] = type
    types.add(type)
}
