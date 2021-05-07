package com.bravedroid.giphy.infrastructure.network

import com.bravedroid.giphy.infrastructure.network.services.GiphyService
import com.bravedroid.giphy.infrastructure.util.createGiphyService
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Test

@ExperimentalCoroutinesApi
class NetworkDataSourceTestIntegration {

    lateinit var giphyService: GiphyService
    lateinit var sut: NetworkDataSource

    @Test
    fun testFetchRandomGif() = runBlocking {
        println("testFetchRandomGif testFetchRandomGif testFetchRandomGif")

        giphyService = createGiphyService()
        sut = NetworkDataSource(giphyService)
        val gifFlow = sut.fetchRandomGif()
        Truth.assertThat(gifFlow.first().url).startsWith("https://media")
        Truth.assertThat(gifFlow.first().url).endsWith("gif&ct=g")
        Truth.assertThat(gifFlow.first().url).endsWith("1231321321g")
    }

}
