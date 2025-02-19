package io.github.warraft.jass.antlr.psi.utils

import io.github.warraft.jass.antlr.psi.JassFun
import io.github.warraft.jass.antlr.psi.JassVar

class JassVarScope(val parent: JassFun?) {
    var function: JassFun? = null

    val all: MutableMap<String, MutableList<JassVar>> = mutableMapOf()

    val definition: MutableMap<String, JassVar> = mutableMapOf()
    fun definition(v: JassVar?) {
        if (v == null) return
        v.scope = this
        all.getOrPut(v.name) { mutableListOf() }.add(v)
        definition[v.name] = v
    }

    fun definition(name: String): JassVar? = definition[name]

    val link: MutableMap<String, MutableList<JassVar>> = mutableMapOf()
    fun link(v: JassVar?) {
        if (v == null) return
        v.scope = this
        all.getOrPut(v.name) { mutableListOf() }.add(v)
        link.getOrPut(v.name) { mutableListOf() }.add(v)
    }

    fun clear() {
        all.clear()
        link.clear()
        definition.clear()
    }
}
