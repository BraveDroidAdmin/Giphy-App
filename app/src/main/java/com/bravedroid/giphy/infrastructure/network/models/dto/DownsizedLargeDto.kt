package com.bravedroid.giphy.infrastructure.network.models.dto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DownsizedLargeDto(
    @SerialName("height") val height: String? = null,
    @SerialName("width") val width: String? = null,
    @SerialName("size") val size: String? = null,
    @SerialName("url") val url: String? = null
)
