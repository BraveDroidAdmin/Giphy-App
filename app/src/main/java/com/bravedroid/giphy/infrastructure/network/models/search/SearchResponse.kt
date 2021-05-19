package com.bravedroid.giphy.infrastructure.network.models.search
import com.bravedroid.giphy.infrastructure.network.models.dto.DataDto
import com.bravedroid.giphy.infrastructure.network.models.dto.MetaDto
import com.bravedroid.giphy.infrastructure.network.models.dto.PaginationDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResponse(
    @SerialName("data") val `data`: List<DataDto    >? = null,
    @SerialName("pagination") val pagination: PaginationDto? = null,
    @SerialName("meta") val meta: MetaDto? = null
)

