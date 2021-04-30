package com.bravedroid.giphy.infrastructure.network.models.random.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImagesDto(
    @SerialName("hd") val hd: HdDto? = null,
    @SerialName("downsized_large") val downsizedLarge: DownsizedLargeDto? = null,
    @SerialName("fixed_height_small_still") val fixedHeightSmallStill: FixedHeightSmallStillDto? = null,
    @SerialName("original") val original: OriginalDto? = null,
    @SerialName("fixed_height_downsampled") val fixedHeightDownsampled: FixedHeightDownsampledDto? = null,
    @SerialName("downsized_still") val downsizedStill: DownsizedStillDto? = null,
    @SerialName("fixed_height_still") val fixedHeightStill: FixedHeightStillDto? = null,
    @SerialName("downsized_medium") val downsizedMedium: DownsizedMediumDto? = null,
    @SerialName("downsized") val downsized: DownsizedDto? = null,
    @SerialName("preview_webp") val previewWebp: PreviewWebpDto? = null,
    @SerialName("original_mp4") val originalMp4: OriginalMp4Dto? = null,
    @SerialName("fixed_height_small") val fixedHeightSmall: FixedHeightSmallDto? = null,
    @SerialName("fixed_height") val fixedHeight: FixedHeightDto? = null,
    @SerialName("downsized_small") val downsizedSmall: DownsizedSmallDto? = null,
    @SerialName("preview") val preview: PreviewDto? = null,
    @SerialName("fixed_width_downsampled") val fixedWidthDownsampled: FixedWidthDownsampledDto? = null,
    @SerialName("fixed_width_small_still") val fixedWidthSmallStill: FixedWidthSmallStillDto? = null,
    @SerialName("fixed_width_small") val fixedWidthSmall: FixedWidthSmallDto? = null,
    @SerialName("original_still") val originalStill: OriginalStillDto? = null,
    @SerialName("fixed_width_still") val fixedWidthStill: FixedWidthStillDto? = null,
    @SerialName("looping") val looping: LoopingDto? = null,
    @SerialName("fixed_width") val fixedWidth: FixedWidthDto? = null,
    @SerialName("preview_gif") val previewGif: PreviewGifDto? = null,
    @SerialName("480w_still") val wStill: WStillDto? = null
)
