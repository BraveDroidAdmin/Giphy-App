package com.bravedroid.giphy.infrastructure.network

import androidx.test.filters.LargeTest
import com.bravedroid.giphy.infrastructure.network.services.GiphyService
import com.bravedroid.giphy.infrastructure.util.GiphyServiceBadFake
import com.bravedroid.giphy.infrastructure.util.GiphyServiceFake
import com.bravedroid.giphy.infrastructure.util.createGiphyService
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class NetworkDataSourceTest {

    private lateinit var giphyServiceFake: GiphyService
    lateinit var giphyServiceBadFake: GiphyService
    lateinit var giphyService: GiphyService
    lateinit var sut: NetworkDataSource

    @Before
    fun setup() {
        giphyService = createGiphyService()
        giphyServiceFake = GiphyServiceFake()
        giphyServiceBadFake = GiphyServiceBadFake()
    }

    @Test
    fun testFetchRandomGifFromFake() = runBlockingTest {
        sut = NetworkDataSource(giphyServiceFake)
        val expectedUrl =
            "https://media0.giphy.com/media/l378tcPSBespR7fjO/200w.gif?cid=840f13ca74f974fd121108b1d0a15571e3a750bc5fd6ee6b&rid=200w.gif&ct=g"
        val gifFlow = sut.fetchRandomGif()
        Truth.assertThat(gifFlow.first().url).isEqualTo(expectedUrl)
    }

    @Test(expected = Exception::class)
    fun testFetchRandomBadGif() = runBlockingTest {
        sut = NetworkDataSource(giphyServiceBadFake)
        val gifFlow = sut.fetchRandomGif()
        gifFlow.collect()
    }

    @LargeTest
    @Test
    fun testFetchRandomGif() = runBlocking {
        sut = NetworkDataSource(giphyService)
        val gifFlow = sut.fetchRandomGif()
        Truth.assertThat(gifFlow.first().url).startsWith("https://media")
        Truth.assertThat(gifFlow.first().url).endsWith("&rid=200w.gif&ct=g")
    }
}
