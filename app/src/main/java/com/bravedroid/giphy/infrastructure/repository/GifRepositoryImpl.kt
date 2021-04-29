package com.bravedroid.giphy.infrastructure.repository

import com.bravedroid.giphy.domain.repository.GifRepository
import com.bravedroid.giphy.infrastructure.network.NetworkDataSource
import javax.inject.Inject

class GifRepositoryImpl @Inject constructor(
    private val networkDataSource: NetworkDataSource,
) : GifRepository {
    override fun getRandom() = networkDataSource.fetchRandomGif()
}
