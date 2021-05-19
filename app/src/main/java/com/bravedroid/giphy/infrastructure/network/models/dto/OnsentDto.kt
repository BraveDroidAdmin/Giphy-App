package com.bravedroid.giphy.infrastructure.network.models.dto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OnsentDto(
    @SerialName("url") val url: String? = null
)