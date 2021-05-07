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
            gifs.add(Gif("https://media3.giphy.com/media/poSqCkhLQcX3q/200w.gif?cid=840f13ca7njl045725koa3quy9t9pq3et0vxmak7k0t1f53j&rid=200w.gif&ct=g"))
            gifs.add(Gif("https://media2.giphy.com/media/hXJZZxD4XqvXNvPw4c/200w.gif?cid=840f13caa0b2c3c4a904b9d97d97677e4355dd1794afc52b&rid=200w.gif&ct=g"))
            gifs.add(Gif("https://media3.giphy.com/media/l378B1UdjJbLWDsAg/200w.gif?cid=840f13ca3b1b72fec0bb7c0476624ccd1fb92c3b9e50503e&rid=200w.gif&ct=g"))
        }
        emit(gifs.shuffled())
    }
}
