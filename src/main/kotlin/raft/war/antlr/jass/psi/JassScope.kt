package raft.war.antlr.jass.psi

class JassScope(val function: JassFun) {

    val stmt: MutableList<IJassNode> = mutableListOf()
}
