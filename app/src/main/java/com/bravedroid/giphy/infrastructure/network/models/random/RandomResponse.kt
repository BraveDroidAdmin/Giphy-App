package com.bravedroid.giphy.infrastructure.network.models.random


import com.bravedroid.giphy.infrastructure.network.models.random.dto.DataDto
import com.bravedroid.giphy.infrastructure.network.models.random.dto.MetaDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RandomResponse(
    @SerialName("data") val `data`: DataDto? = null,
    @SerialName("meta") val meta: MetaDto? = null
)
