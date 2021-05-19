package com.bravedroid.giphy.infrastructure.network

import com.bravedroid.giphy.domain.Gif
import com.bravedroid.giphy.infrastructure.network.mappers.GifMapper
import com.bravedroid.giphy.infrastructure.network.services.GiphyService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NetworkDataSource @Inject constructor(
    private val gifMapper: GifMapper,
    private val giphyService: GiphyService,
) {
    fun fetchRandomGif() = flow {
        val randomResponse = giphyService.fetchRandom()
        emit(gifMapper.fromRandomResponse(randomResponse))
    }

    fun fetchGifs(query: String) = flow {
        val gifs = mutableListOf<Gif>()
        val searchResponse = giphyService.fetchGifs(query)
        emit(gifMapper.fromSearchResponse(searchResponse))
    }
}
