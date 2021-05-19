package com.bravedroid.giphy.infrastructure.repository

import com.bravedroid.giphy.domain.Gif
import com.bravedroid.giphy.domain.repository.GifRepository
import com.bravedroid.giphy.infrastructure.network.NetworkDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GifRepositoryImpl @Inject constructor(
    private val networkDataSource: NetworkDataSource,
) : GifRepository {
    override fun getRandom() = networkDataSource.fetchRandomGif()
    override fun getGifs(query: String): Flow<List<Gif>> = networkDataSource.fetchGifs(query)
}
