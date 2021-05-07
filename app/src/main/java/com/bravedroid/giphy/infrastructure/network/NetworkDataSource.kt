package com.bravedroid.giphy.infrastructure.network

import com.bravedroid.giphy.domain.Gif
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

    fun fetchGifs() = flow {
        val gifs = mutableListOf<Gif>()

        repeat(20) {
            gifs.add(Gif("https://media0.giphy.com/media/l378tcPSBespR7fjO/giphy-downsized.gif?cid=840f13ca74f974fd121108b1d0a15571e3a750bc5fd6ee6b&rid=giphy-downsized.gif&ct=g"))
        }
        emit(gifs)
    }
}
