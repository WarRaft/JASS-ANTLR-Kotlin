package io.github.warraft.jass.antlr.psi

import io.github.warraft.jass.antlr.state.JassState

class JassVarScope(
    val state: JassState,
    val function: JassFun? = null,
) {
    val definitions: MutableMap<String, MutableList<JassVar>> = mutableMapOf()
    val usages: MutableMap<String, MutableList<JassVar>> = mutableMapOf()

    fun add(v: JassVar?, definition: Boolean = false) {
        val name = v?.name
        if (name == null) return
        v.scope = this
        usages.getOrPut(name) { mutableListOf() }.add(v)
        if (definition) {
            this.definitions.getOrPut(name) { mutableListOf() }.add(v)
        }
    }

    fun definition(v: JassVar?): JassVar? = definition(v?.name)
    fun definition(name: String?): JassVar? {
        if (name == null) return null
        val list = definitions[name] ?: return null
        return list.lastOrNull()
    }

    fun definitions(v: JassVar?): List<JassVar> = definitions(v?.name)
    fun definitions(name: String?): List<JassVar> {
        if (name == null) return emptyList()
        val list = definitions[name] ?: return emptyList()
        return list
    }

    fun usages(v: JassVar?): List<JassVar> = usages(v?.name)
    fun usages(name: String?): List<JassVar> {
        if (name == null) return emptyList()
        val list = usages[name] ?: return emptyList()
        return list
    }

    fun clear() {
        definitions.clear()
        usages.clear()
    }
}
