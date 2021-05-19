package com.bravedroid.giphy.infrastructure.network.models.dto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PaginationDto(
    @SerialName("total_count") val totalCount: Int? = null,
    @SerialName("count") val count: Int? = null,
    @SerialName("offset") val offset: Int? = null
)
