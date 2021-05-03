package com.bravedroid.giphy.infrastructure.network.mappers

import com.bravedroid.giphy.domain.Gif
import com.bravedroid.giphy.domain.exception.ResourceNotFoundException
import com.bravedroid.giphy.infrastructure.network.models.random.RandomResponse

object GifMapper {
    fun fromRandomResponse(randomResponse: RandomResponse): Gif {
            val url =
                randomResponse.data?.images?.downsized?.url ?: throw ResourceNotFoundException()
            return Gif(url)
        }
}
