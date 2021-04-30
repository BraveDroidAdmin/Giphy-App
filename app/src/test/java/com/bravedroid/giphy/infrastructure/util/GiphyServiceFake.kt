package com.bravedroid.giphy.infrastructure.util

import com.bravedroid.giphy.infrastructure.network.models.random.RandomResponse
import com.bravedroid.giphy.infrastructure.network.services.GiphyService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

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

private const val BASE_URL = "https://api.giphy.com/v1/gifs/"
private const val OK_HTTP_CONNECT_TIMEOUT = 60L
private const val OK_HTTP_WRITE_TIMEOUT = 60L
private const val OK_HTTP_READ_TIMEOUT = 60L

fun createGiphyService(): GiphyService {

    val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(OK_HTTP_CONNECT_TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(OK_HTTP_WRITE_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(OK_HTTP_READ_TIMEOUT, TimeUnit.SECONDS)
        .build()

   return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(Json{
            isLenient = true
            ignoreUnknownKeys = true
        }.asConverterFactory("application/json".toMediaType()))
        .build()
        .create(GiphyService::class.java)
}
