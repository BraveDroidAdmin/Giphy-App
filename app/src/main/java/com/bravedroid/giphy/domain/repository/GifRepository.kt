package com.bravedroid.giphy.domain.repository

import com.bravedroid.giphy.domain.Gif
import kotlinx.coroutines.flow.Flow

interface GifRepository {
    fun getRandom(): Flow<Gif>
}
