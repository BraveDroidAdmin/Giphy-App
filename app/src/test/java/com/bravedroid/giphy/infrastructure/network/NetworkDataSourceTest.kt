package com.bravedroid.giphy.infrastructure.network

import com.bravedroid.giphy.infrastructure.network.services.GiphyService
import com.bravedroid.giphy.infrastructure.util.GiphyServiceBadFake
import com.bravedroid.giphy.infrastructure.util.GiphyServiceFake
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import java.lang.Exception

@ExperimentalCoroutinesApi
class NetworkDataSourceTest {

    private lateinit var giphyServiceFake: GiphyService
    lateinit var giphyServiceBadFake: GiphyService
    lateinit var sut: NetworkDataSource

    @Before
    fun setup() {
        giphyServiceFake = GiphyServiceFake()
        giphyServiceBadFake = GiphyServiceBadFake()
    }

    @Test
    fun testFetchRandomGif() = runBlockingTest{
        sut = NetworkDataSource(giphyServiceFake)
        val expectedUrl = "https://media0.giphy.com/media/l378tcPSBespR7fjO/200w.gif?cid=840f13ca74f974fd121108b1d0a15571e3a750bc5fd6ee6b&rid=200w.gif&ct=g"
        val gifFlow = sut.fetchRandomGif()
        Truth.assertThat(gifFlow.first().url).isEqualTo(expectedUrl)
    }

    @Test(expected = Exception::class)
    fun testFetchRandomBadGif() = runBlockingTest{
        sut = NetworkDataSource(giphyServiceBadFake)
        val expectedUrl = "https://media0.giphy.com/media/l378tcPSBespR7fjO/200w.gif?cid=840f13ca74f974fd121108b1d0a15571e3a750bc5fd6ee6b&rid=200w.gif&ct=g"
        val gifFlow = sut.fetchRandomGif()
        gifFlow.collect()
    }
}
