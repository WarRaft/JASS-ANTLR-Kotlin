package raft.war.jass.checker.error

class Error(val id: Id, val line: Int, val char: Int, val message: String) {
    override fun toString(): String = "$id [$line:$char] $message"
}
