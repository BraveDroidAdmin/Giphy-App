package com.bravedroid.giphy.infrastructure.network.models.dto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PreviewDto(
    @SerialName("height") val height: String? = null,
    @SerialName("width") val width: String? = null,
    @SerialName("mp4_size") val mp4Size: String? = null,
    @SerialName("mp4") val mp4: String? = null
)
