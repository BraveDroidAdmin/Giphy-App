package com.bravedroid.giphy.infrastructure.network.mappers

import com.bravedroid.giphy.domain.Gif
import com.bravedroid.giphy.domain.exception.ResourceNotFoundException
import com.bravedroid.giphy.infrastructure.network.models.random.RandomResponse
import com.bravedroid.giphy.infrastructure.network.models.search.SearchResponse
import com.bravedroid.giphy.util.Logger
import javax.inject.Inject

class GifMapper @Inject constructor() {
    @Inject
    lateinit var logger: Logger
    fun fromRandomResponse(randomResponse: RandomResponse): Gif {
        val url =
            randomResponse.data?.images?.downsized?.url ?: throw ResourceNotFoundException()
        return Gif(url)
    }

    fun fromSearchResponse(searchResponse: SearchResponse): List<Gif> {
        val myList = mutableListOf<Gif>()
        searchResponse.data?.forEach {
            if (it.images?.downsized?.url != null) {
                logger.log("TRY downsized ", "GIF_MAPPER")
                myList.add(Gif(it.images.downsized.url))
            } else {
                logger.log("NO downsized ", "GIF_MAPPER")
            }
        }
        return myList
    }
}
