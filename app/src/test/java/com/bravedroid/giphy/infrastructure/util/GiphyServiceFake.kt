package com.bravedroid.giphy.infrastructure.util

import com.bravedroid.giphy.infrastructure.network.models.random.RandomResponse
import com.bravedroid.giphy.infrastructure.network.services.GiphyService
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class GiphyServiceFake : GiphyService {
    override suspend fun fetchRandom(): RandomResponse {
        val json = this::class.java.getResource("/GET_random_gif.json")!!.readText()
        return Json.decodeFromString(json)
    }
}

class GiphyServiceBadFake : GiphyService {
    override suspend fun fetchRandom(): RandomResponse {
        val json = this::class.java.getResource("/GET_random_gif_bad.json")!!.readText()
        return Json.decodeFromString(json)
    }
}
