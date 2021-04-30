package com.bravedroid.giphy.infrastructure.network.models.random.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OriginalStillDto(
    @SerialName("height") val height: String? = null,
    @SerialName("size") val size: String? = null,
    @SerialName("url") val url: String? = null,
    @SerialName("width") val width: String? = null
)
