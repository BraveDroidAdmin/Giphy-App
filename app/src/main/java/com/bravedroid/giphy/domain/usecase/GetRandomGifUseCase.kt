package com.bravedroid.giphy.domain.usecase

import com.bravedroid.giphy.domain.repository.GifRepository
import javax.inject.Inject

class GetRandomGifUseCase @Inject constructor(private val gifRepository: GifRepository) {
    operator fun invoke() = gifRepository.getRandom()
}

