package com.bravedroid.giphy.infrastructure.network.models.dto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MetaDto(
    @SerialName("status") val status: Int? = null,
    @SerialName("msg") val msg: String? = null,
    @SerialName("response_id") val responseId: String? = null
)
