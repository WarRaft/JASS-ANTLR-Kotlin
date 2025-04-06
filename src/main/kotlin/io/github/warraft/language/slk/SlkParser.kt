package io.github.warraft.language.slk

import io.github.warraft.language.slk.psi.*
import io.github.warraft.lsp.data.Position
import io.github.warraft.lsp.data.Range
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.IntStream
import org.antlr.v4.runtime.misc.Interval

class SlkParser {

    val record = mutableListOf<SlkRecord>()
    val map = mutableMapOf<Int, MutableMap<Int, SlkValue>>()

    fun setValue(y: Int, x: Int, value: SlkValue?) {
        if (value == null) return
        map.getOrPut(y) { mutableMapOf() }[x] = value
    }

    fun setValue(rec: SlkRecord?) {
        if (rec == null) return
        if (rec.kind != SlkRecordKind.Column) return
        setValue(rec.y, rec.x, rec.value)
    }

    fun getValue(y: Int, x: Int): SlkValue? = map[y]?.get(x)

    private enum class Mode {
        Record,
        Value,
        End
    }

    fun parse(stream: CharStream) {
        record.clear()

        var line = 0
        var col = -1
        var index = -1

        var x = 0
        var y = 0

        fun nextSymbol(): String? {
            col++
            index++
            stream.seek(index)
            if (stream.LA(1) == IntStream.EOF) return null
            return stream.getText(Interval(index, index))
        }

        var stringHub = ""
        var mode = Mode.Record
        var si = 0


        var rec: SlkRecord? = null
        fun recCommit() {
            if (mode != Mode.Record) return

            rec = SlkRecord(
                x = x,
                y = y,
                name = SlkToken(
                    text = stringHub,
                    range = Range.Companion.of(line, si, line, col),
                    length = col - si
                )
            ).also { record.add(it) }

            stringHub = ""
            if (rec.kind == SlkRecordKind.End) mode = Mode.End
        }

        var field: SlkField? = null
        fun fieldCommit() {
            val value = nextSymbol() ?: return

            field = SlkField(
                name = SlkToken(
                    text = value,
                    range = Range.Companion.of(line, col - 1, line, col + 1),
                    length = 2,
                )
            ).also {
                rec?.field?.add(it)
            }
        }

        var value: SlkValue? = null
        fun valCommit() {
            if (mode != Mode.Value) return

            value = SlkValue(
                text = SlkToken(
                    text = stringHub,
                    range = Range.Companion.of(line, si + 1, line, col),
                    length = col - si - 1
                )
            ).also {
                field?.value = it
            }

            if (rec != null) when (field?.kind) {
                SlkFieldKind.X -> {
                    if (rec.kind != SlkRecordKind.Bounds) value.i?.also {
                        x = it
                        rec.x = x
                    }
                }

                SlkFieldKind.Y -> {
                    if (rec.kind != SlkRecordKind.Bounds) value.i?.also {
                        y = it
                        rec.y = y
                    }
                }

                SlkFieldKind.Value -> {
                    rec.value = value
                }

                else -> {}
            }

            stringHub = ""
        }

        while (true) {
            if (mode == Mode.End) break
            val ch = nextSymbol()

            var endLine = ch == null

            if (ch != null) when (ch.codePointAt(0)) {
                13 /* \r */ -> {
                    if (stream.LA(2) == 10) index++
                    endLine = true
                }

                10 /* \n */ -> endLine = true

                59 /* ; */ -> {
                    when (mode) {
                        Mode.Record -> {
                            recCommit()
                            if (mode == Mode.End) break
                            valCommit()
                            fieldCommit()
                            si = col
                            mode = Mode.Value
                            continue
                        }

                        Mode.Value -> {
                            if (stream.LA(2) == 59) {
                                index++
                                col++
                            } else {
                                valCommit()
                                fieldCommit()
                                si = col
                                continue
                            }
                        }

                        Mode.End -> break
                    }
                }
            }

            if (endLine) {
                valCommit()
                recCommit()

                setValue(rec?.also {
                    it.end = Position(
                        line = line.toUInt(),
                        character = col.toUInt()
                    )
                })

                if (mode == Mode.End) break
                mode = Mode.Record

                si = 0
                col = -1
                line++
            }

            if (col < 0) continue
            when (mode) {
                Mode.End -> break
                else -> if (ch != null) stringHub += ch
            }
        }
    }

    fun clear() {
        record.clear()
        map.clear()
    }

}
