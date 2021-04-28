package com.bravedroid.giphy.domain.repository

import com.bravedroid.giphy.domain.Gif

interface GifRepository {
    fun getRandom (): Gif
}
