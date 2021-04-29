package com.bravedroid.giphy.infrastructure.network

import com.bravedroid.giphy.infrastructure.network.mappers.GifMapper
import com.bravedroid.giphy.infrastructure.network.services.GiphyService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NetworkDataSource @Inject constructor(
    private val giphyService: GiphyService,
) {
    fun fetchRandomGif() = flow {
        val randomResponse = giphyService.fetchRandom()
        emit(GifMapper.fromRandomResponse(randomResponse))
    }
}
