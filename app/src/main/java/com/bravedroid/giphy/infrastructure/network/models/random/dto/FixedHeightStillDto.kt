package com.bravedroid.giphy.infrastructure.network.models.random.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FixedHeightStillDto(
    @SerialName("height") val height: String?,
    @SerialName("size") val size: String?,
    @SerialName("url") val url: String?,
    @SerialName("width") val width: String?
)
