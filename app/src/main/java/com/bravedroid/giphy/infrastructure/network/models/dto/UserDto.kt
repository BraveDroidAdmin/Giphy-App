package com.bravedroid.giphy.infrastructure.network.models.dto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    @SerialName("avatar_url") val avatarUrl: String? = null,
    @SerialName("banner_image") val bannerImage: String? = null,
    @SerialName("banner_url") val bannerUrl: String? = null,
    @SerialName("profile_url") val profileUrl: String? = null,
    @SerialName("username") val username: String? = null,
    @SerialName("display_name") val displayName: String? = null,
    @SerialName("description") val description: String? = null,
    @SerialName("instagram_url") val instagramUrl: String? = null,
    @SerialName("website_url") val websiteUrl: String? = null,
    @SerialName("is_verified") val isVerified: Boolean? = null
)
