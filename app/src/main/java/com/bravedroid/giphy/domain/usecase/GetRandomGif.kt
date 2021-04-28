package com.bravedroid.giphy.domain.usecase

import com.bravedroid.giphy.domain.Gif
import com.bravedroid.giphy.domain.repository.GifRepository
import javax.inject.Inject

class GetRandomGif @Inject constructor(private val gifRepository: GifRepository) {
    operator fun invoke(): Gif = gifRepository.getRandom()
}
