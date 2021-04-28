package com.bravedroid.giphy.infrastructure.repository

import com.bravedroid.giphy.domain.Gif
import com.bravedroid.giphy.domain.exception.ResourceNotFoundException
import com.bravedroid.giphy.domain.repository.GifRepository
import com.bravedroid.giphy.infrastructure.network.models.random.RandomResponse
import javax.inject.Inject

class GifRepositoryImpl @Inject constructor(private val randomResponse: RandomResponse) : GifRepository {
    override fun getRandom(): Gif {
        val url = randomResponse.data?.images?.fixedWidth?.url ?: throw ResourceNotFoundException()
        return Gif(url)
    }
}
