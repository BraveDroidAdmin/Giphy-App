package com.bravedroid.giphy.infrastructure.network.models.random.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DataDto(
    @SerialName("type") val type: String?,
    @SerialName("id") val id: String?,
    @SerialName("url") val url: String?,
    @SerialName("slug") val slug: String?,
    @SerialName("bitly_gif_url") val bitlyGifUrl: String?,
    @SerialName("bitly_url") val bitlyUrl: String?,
    @SerialName("embed_url") val embedUrl: String?,
    @SerialName("username") val username: String?,
    @SerialName("source") val source: String?,
    @SerialName("title") val title: String?,
    @SerialName("rating") val rating: String?,
    @SerialName("content_url") val contentUrl: String?,
    @SerialName("source_tld") val sourceTld: String?,
    @SerialName("source_post_url") val sourcePostUrl: String?,
    @SerialName("is_sticker") val isSticker: Int?,
    @SerialName("import_datetime") val importDatetime: String?,
    @SerialName("trending_datetime") val trendingDatetime: String?,
    @SerialName("images") val images: ImagesDto?,
    @SerialName("image_original_url") val imageOriginalUrl: String?,
    @SerialName("image_url") val imageUrl: String?,
    @SerialName("image_mp4_url") val imageMp4Url: String?,
    @SerialName("image_frames") val imageFrames: String?,
    @SerialName("image_width") val imageWidth: String?,
    @SerialName("image_height") val imageHeight: String?,
    @SerialName("fixed_height_downsampled_url") val fixedHeightDownsampledUrl: String?,
    @SerialName("fixed_height_downsampled_width") val fixedHeightDownsampledWidth: String?,
    @SerialName("fixed_height_downsampled_height") val fixedHeightDownsampledHeight: String?,
    @SerialName("fixed_width_downsampled_url") val fixedWidthDownsampledUrl: String?,
    @SerialName("fixed_width_downsampled_width") val fixedWidthDownsampledWidth: String?,
    @SerialName("fixed_width_downsampled_height") val fixedWidthDownsampledHeight: String?,
    @SerialName("fixed_height_small_url") val fixedHeightSmallUrl: String?,
    @SerialName("fixed_height_small_still_url") val fixedHeightSmallStillUrl: String?,
    @SerialName("fixed_height_small_width") val fixedHeightSmallWidth: String?,
    @SerialName("fixed_height_small_height") val fixedHeightSmallHeight: String?,
    @SerialName("fixed_width_small_url") val fixedWidthSmallUrl: String?,
    @SerialName("fixed_width_small_still_url") val fixedWidthSmallStillUrl: String?,
    @SerialName("fixed_width_small_width") val fixedWidthSmallWidth: String?,
    @SerialName("fixed_width_small_height") val fixedWidthSmallHeight: String?,
    @SerialName("caption") val caption: String?
)
