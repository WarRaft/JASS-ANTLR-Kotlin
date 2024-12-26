package raft.war.jass.checker

class Error(val id: ErrorId, val line: Int, val char: Int, val message: String) {
    override fun toString(): String = "$id [$line:$char] $message"
}
