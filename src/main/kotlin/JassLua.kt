@file:Suppress("DuplicatedCode")

import raft.war.antlr.jass.JassState
import raft.war.antlr.lua.JassLua
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.absolute

fun j2l(path: Path): Path = path.resolveSibling(path.fileName.toString().replaceAfterLast('.', "lua"))

fun main() {
    if (false) {
        val cj = JassState()
        val cjp = Paths.get("src", "test", "resources", "common.j")
        cj.parse(cjp.absolute().toString())
        JassLua(cj, j2l(cjp)).convert()
        cj.errors.forEach { print("cj: $it \n") }

        val bj = JassState()
        val bjp = Paths.get("src", "test", "resources", "blizzard.j")
        bj.parse(bjp.absolute().toString(), listOf(cj))
        JassLua(bj, j2l(bjp)).convert()
        bj.errors.forEach { print("bj: $it \n") }
    }

    val j = JassState()
    val jp = Paths.get("src", "test", "resources", "test.j")
    //j.parse(jp.absolute().toString(), listOf(cj, bj))
    j.parse(jp.absolute().toString())
    JassLua(j, j2l(jp)).convert()

    j.errors.forEach { print("j: $it \n") }

}
