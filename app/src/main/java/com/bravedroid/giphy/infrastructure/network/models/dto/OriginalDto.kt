package com.bravedroid.giphy.infrastructure.network.models.dto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OriginalDto(
    @SerialName("height") val height: String? = null,
    @SerialName("width") val width: String? = null,
    @SerialName("size") val size: String? = null,
    @SerialName("url") val url: String? = null,
    @SerialName("mp4_size") val mp4Size: String? = null,
    @SerialName("mp4") val mp4: String? = null,
    @SerialName("webp_size") val webpSize: String? = null,
    @SerialName("webp") val webp: String? = null,
    @SerialName("frames") val frames: String? = null,
    @SerialName("hash") val hash: String? = null
)