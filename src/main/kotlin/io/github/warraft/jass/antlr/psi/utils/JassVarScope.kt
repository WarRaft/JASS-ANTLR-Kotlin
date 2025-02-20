package io.github.warraft.jass.antlr.psi.utils

import io.github.warraft.jass.antlr.psi.JassFun
import io.github.warraft.jass.antlr.psi.JassVar

class JassVarScope(val parent: JassFun?) {
    var function: JassFun? = null

    val all: MutableMap<String, MutableList<JassVar>> = mutableMapOf()

    val definition: MutableMap<String, JassVar> = mutableMapOf()
    fun definition(v: JassVar?) {
        val name = v?.name ?: return
        v.scope = this
        all.getOrPut(name) { mutableListOf() }.add(v)
        definition[name] = v
    }

    fun definition(name: String?): JassVar? = definition[name]

    val link: MutableMap<String, MutableList<JassVar>> = mutableMapOf()

    fun link(v: JassVar?) {
        val name = v?.name ?: return
        v.scope = this
        all.getOrPut(name) { mutableListOf() }.add(v)
        link.getOrPut(name) { mutableListOf() }.add(v)
    }

    fun clear() {
        all.clear()
        link.clear()
        definition.clear()
    }
}
