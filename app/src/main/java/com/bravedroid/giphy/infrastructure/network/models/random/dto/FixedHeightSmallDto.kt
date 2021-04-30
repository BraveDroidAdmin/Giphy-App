package com.bravedroid.giphy.infrastructure.network.models.random.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FixedHeightSmallDto(
    @SerialName("height") val height: String? = null,
    @SerialName("mp4") val mp4: String? = null,
    @SerialName("mp4_size") val mp4Size: String? = null,
    @SerialName("size") val size: String? = null,
    @SerialName("url") val url: String? = null,
    @SerialName("webp") val webp: String? = null,
    @SerialName("webp_size") val webpSize: String? = null,
    @SerialName("width") val width: String? = null
)
