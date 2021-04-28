package com.bravedroid.giphy.infrastructure.network.models.random.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MetaDto(
    @SerialName("status") val status: Int?,
    @SerialName("msg") val msg: String?,
    @SerialName("response_id") val responseId: String?
)
