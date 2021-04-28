package com.bravedroid.giphy.infrastructure.network.models.random.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FixedHeightDto(
    @SerialName("height") val height: String?,
    @SerialName("mp4") val mp4: String?,
    @SerialName("mp4_size") val mp4Size: String?,
    @SerialName("size") val size: String?,
    @SerialName("url") val url: String?,
    @SerialName("webp") val webp: String?,
    @SerialName("webp_size") val webpSize: String?,
    @SerialName("width") val width: String?
)
