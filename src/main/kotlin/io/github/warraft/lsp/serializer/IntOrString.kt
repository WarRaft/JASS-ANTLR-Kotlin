package io.github.warraft.lsp.serializer

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.int
import kotlinx.serialization.json.intOrNull

import kotlinx.serialization.*

@Serializable(with = IntOrStringSerializer::class)
sealed class IntOrString {
    @Serializable
    data class Ival(val value: Int) : IntOrString()

    @Serializable
    data class Sval(val value: String) : IntOrString()

    companion object {
        fun from(value: Any): IntOrString = when (value) {
            is Int -> Ival(value)
            is String -> Sval(value)
            else -> throw IllegalArgumentException("Unsupported type for IntOrString: $value")
        }
    }
}

object IntOrStringSerializer : KSerializer<IntOrString> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("IntOrString", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: IntOrString) {
        when (value) {
            is IntOrString.Ival -> encoder.encodeInt(value.value)
            is IntOrString.Sval -> encoder.encodeString(value.value)
        }
    }

    override fun deserialize(decoder: Decoder): IntOrString {
        return when (val element = (decoder as JsonDecoder).decodeJsonElement()) {
            is JsonPrimitive -> {
                when {
                    element.isString -> IntOrString.Sval(element.content)
                    element.intOrNull != null -> IntOrString.Ival(element.int)
                    else -> throw SerializationException("Invalid IntOrString format: $element")
                }
            }

            else -> throw SerializationException("Expected a primitive for IntOrString")
        }
    }
}
