package com.bravedroid.giphy.infrastructure.network.mappers

import com.bravedroid.giphy.domain.Gif
import com.bravedroid.giphy.domain.exception.ResourceNotFoundException
import com.bravedroid.giphy.infrastructure.network.models.random.RandomResponse
import com.bravedroid.giphy.infrastructure.network.models.search.SearchResponse

object GifMapper {
    fun fromRandomResponse(randomResponse: RandomResponse): Gif {
        val url =
            randomResponse.data?.images?.downsized?.url ?: throw ResourceNotFoundException()
        return Gif(url)
    }

    fun fromSearchResponse(searchResponse: SearchResponse): List<Gif> {
        val myList = mutableListOf<Gif>()
        searchResponse.data?.forEach {
            myList.add(Gif(it.images?.downsized?.url ?: throw ResourceNotFoundException()))
        }
        return myList
    }
}
