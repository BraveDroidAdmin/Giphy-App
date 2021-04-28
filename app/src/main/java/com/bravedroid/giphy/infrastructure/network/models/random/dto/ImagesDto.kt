package com.bravedroid.giphy.infrastructure.network.models.random.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImagesDto(
    @SerialName("hd") val hd: HdDto?,
    @SerialName("downsized_large") val downsizedLarge: DownsizedLargeDto?,
    @SerialName("fixed_height_small_still") val fixedHeightSmallStill: FixedHeightSmallStillDto?,
    @SerialName("original") val original: OriginalDto?,
    @SerialName("fixed_height_downsampled") val fixedHeightDownsampled: FixedHeightDownsampledDto?,
    @SerialName("downsized_still") val downsizedStill: DownsizedStillDto?,
    @SerialName("fixed_height_still") val fixedHeightStill: FixedHeightStillDto?,
    @SerialName("downsized_medium") val downsizedMedium: DownsizedMediumDto?,
    @SerialName("downsized") val downsized: DownsizedDto?,
    @SerialName("preview_webp") val previewWebp: PreviewWebpDto?,
    @SerialName("original_mp4") val originalMp4: OriginalMp4Dto?,
    @SerialName("fixed_height_small") val fixedHeightSmall: FixedHeightSmallDto?,
    @SerialName("fixed_height") val fixedHeight: FixedHeightDto?,
    @SerialName("downsized_small") val downsizedSmall: DownsizedSmallDto?,
    @SerialName("preview") val preview: PreviewDto?,
    @SerialName("fixed_width_downsampled") val fixedWidthDownsampled: FixedWidthDownsampledDto?,
    @SerialName("fixed_width_small_still") val fixedWidthSmallStill: FixedWidthSmallStillDto?,
    @SerialName("fixed_width_small") val fixedWidthSmall: FixedWidthSmallDto?,
    @SerialName("original_still") val originalStill: OriginalStillDto?,
    @SerialName("fixed_width_still") val fixedWidthStill: FixedWidthStillDto?,
    @SerialName("looping") val looping: LoopingDto?,
    @SerialName("fixed_width") val fixedWidth: FixedWidthDto?,
    @SerialName("preview_gif") val previewGif: PreviewGifDto?,
    @SerialName("480w_still") val wStill: WStillDto?
)
