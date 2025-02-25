package io.github.warraft.jass.antlr.psi
import io.github.warraft.jass.antlr.state.JassState

class JassTypeScope(
    val state: JassState,
) {

    val definitions: MutableMap<String, MutableList<JassType>> = mutableMapOf()
    val usages: MutableMap<String, MutableList<JassType>> = mutableMapOf()

    fun add(t: JassType?, definition: Boolean = false) {
        val name = t?.name ?: return
        usages.getOrPut(name) { mutableListOf() }.add(t)
        if (definition) {
            this.definitions.getOrPut(name) { mutableListOf() }.add(t)
        }
    }

    fun definition(t: JassType?): JassType? = definition(t?.name)
    fun definition(name: String?): JassType? {
        if (name == null) return null
        val list = definitions[name] ?: return null
        return list.lastOrNull()
    }

    fun definitions(v: JassType?): List<JassType> = definitions(v?.name)
    fun definitions(name: String?): List<JassType> {
        if (name == null) return emptyList()
        val list = definitions[name] ?: return emptyList()
        return list
    }

    fun usages(v: JassType?): List<JassType> = usages(v?.name)
    fun usages(name: String?): List<JassType> {
        if (name == null) return emptyList()
        val list = usages[name] ?: return emptyList()
        return list
    }

    fun clear() {
        definitions.clear()
        usages.clear()
    }
}


