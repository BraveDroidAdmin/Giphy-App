package com.bravedroid.giphy.infrastructure.network.models.random.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DataDto(
    @SerialName("type") val type: String? = null,
    @SerialName("id") val id: String? = null,
    @SerialName("url") val url: String? = null,
    @SerialName("slug") val slug: String? = null,
    @SerialName("bitly_gif_url") val bitlyGifUrl: String? = null,
    @SerialName("bitly_url") val bitlyUrl: String? = null,
    @SerialName("embed_url") val embedUrl: String? = null,
    @SerialName("username") val username: String? = null,
    @SerialName("source") val source: String? = null,
    @SerialName("title") val title: String? = null,
    @SerialName("rating") val rating: String? = null,
    @SerialName("content_url") val contentUrl: String? = null,
    @SerialName("source_tld") val sourceTld: String? = null,
    @SerialName("source_post_url") val sourcePostUrl: String? = null,
    @SerialName("is_sticker") val isSticker: Int? = null,
    @SerialName("import_datetime") val importDatetime: String? = null,
    @SerialName("trending_datetime") val trendingDatetime: String? = null,
    @SerialName("images") val images: ImagesDto? = null,
    @SerialName("image_original_url") val imageOriginalUrl: String? = null,
    @SerialName("image_url") val imageUrl: String? = null,
    @SerialName("image_mp4_url") val imageMp4Url: String? = null,
    @SerialName("image_frames") val imageFrames: String? = null,
    @SerialName("image_width") val imageWidth: String? = null,
    @SerialName("image_height") val imageHeight: String? = null,
    @SerialName("fixed_height_downsampled_url") val fixedHeightDownsampledUrl: String? = null,
    @SerialName("fixed_height_downsampled_width") val fixedHeightDownsampledWidth: String? = null,
    @SerialName("fixed_height_downsampled_height") val fixedHeightDownsampledHeight: String? = null,
    @SerialName("fixed_width_downsampled_url") val fixedWidthDownsampledUrl: String? = null,
    @SerialName("fixed_width_downsampled_width") val fixedWidthDownsampledWidth: String? = null,
    @SerialName("fixed_width_downsampled_height") val fixedWidthDownsampledHeight: String? = null,
    @SerialName("fixed_height_small_url") val fixedHeightSmallUrl: String? = null,
    @SerialName("fixed_height_small_still_url") val fixedHeightSmallStillUrl: String? = null,
    @SerialName("fixed_height_small_width") val fixedHeightSmallWidth: String? = null,
    @SerialName("fixed_height_small_height") val fixedHeightSmallHeight: String? = null,
    @SerialName("fixed_width_small_url") val fixedWidthSmallUrl: String? = null,
    @SerialName("fixed_width_small_still_url") val fixedWidthSmallStillUrl: String? = null,
    @SerialName("fixed_width_small_width") val fixedWidthSmallWidth: String? = null,
    @SerialName("fixed_width_small_height") val fixedWidthSmallHeight: String? = null,
    @SerialName("caption") val caption: String? = null
)
