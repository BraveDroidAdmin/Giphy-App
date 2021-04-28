package com.bravedroid.giphy.infrastructure.network.models.random.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WStillDto(
    @SerialName("url") val url: String?,
    @SerialName("width") val width: String?,
    @SerialName("height") val height: String?
)
