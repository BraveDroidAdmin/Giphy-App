package com.bravedroid.giphy.infrastructure.network.models.random.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoopingDto(
    @SerialName("mp4") val mp4: String? = null,
    @SerialName("mp4_size") val mp4Size: String? = null
)
