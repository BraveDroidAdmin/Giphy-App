package com.bravedroid.giphy.infrastructure.network.models.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnalyticsDto(
    @SerialName("onload") val onload: OnloadDto? = null,
    @SerialName("onclick") val onclick: OnclickDto? = null,
    @SerialName("onsent") val onsent: OnsentDto? = null
)
