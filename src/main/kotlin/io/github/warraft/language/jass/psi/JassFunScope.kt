package io.github.warraft.language.jass.psi

import io.github.warraft.language.jass.state.JassState

class JassFunScope(
    val state: JassState,
) {
    val natives: MutableList<JassFun> = mutableListOf()
    val functions: MutableList<JassFun> = mutableListOf()

    val definitions: MutableMap<String, MutableList<JassFun>> = mutableMapOf()
    val usages: MutableMap<String, MutableList<JassFun>> = mutableMapOf()

    fun add(f: JassFun?, definition: Boolean = false) {
        val name = f?.name ?: return
        f.scope = this
        usages.getOrPut(name) { mutableListOf() }.add(f)
        if (definition) {
            this.definitions.getOrPut(name) { mutableListOf() }.add(f)
        }
    }

    fun definition(v: JassFun?): JassFun? = definition(v?.name)
    fun definition(name: String?): JassFun? {
        if (name == null) return null
        val list = definitions[name] ?: return null
        return list.lastOrNull()
    }

    fun definitions(v: JassFun?): List<JassFun> = definitions(v?.name)
    fun definitions(name: String?): List<JassFun> {
        if (name == null) return emptyList()
        val list = definitions[name] ?: return emptyList()
        return list
    }

    fun usages(v: JassFun?): List<JassFun> = usages(v?.name)
    fun usages(name: String?): List<JassFun> {
        if (name == null) return emptyList()
        val list = usages[name] ?: return emptyList()
        return list
    }

    fun clear() {
        natives.clear()
        functions.clear()

        definitions.clear()
        usages.clear()
    }
}

