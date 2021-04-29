package com.bravedroid.giphy.infrastructure.repository

import com.bravedroid.giphy.domain.Gif
import com.bravedroid.giphy.domain.exception.ResourceNotFoundException
import com.bravedroid.giphy.infrastructure.network.NetworkDataSource
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.*

@ExperimentalCoroutinesApi
class GifRepositoryImplTest {

    private lateinit var networkDataSourceMock: NetworkDataSource
    private lateinit var sut: GifRepositoryImpl

    @Before
    fun setUp() {
        networkDataSourceMock = mock(NetworkDataSource::class.java)
        sut = GifRepositoryImpl(networkDataSourceMock)
    }

    @Test
    fun testGetRandom() = runBlockingTest{
        val expected = flowOf(Gif("test"))
        `when`(networkDataSourceMock.fetchRandomGif()).thenReturn(expected)
        sut.getRandom()
        verify(networkDataSourceMock).fetchRandomGif()
        Truth.assertThat(sut.getRandom().first()).isEqualTo(expected.first())
    }


    @Test(expected = ResourceNotFoundException::class)
    fun testGetException() = runBlockingTest{
        `when`(networkDataSourceMock.fetchRandomGif()).thenReturn(
            flow{
               throw ResourceNotFoundException()
            }
        )
        sut.getRandom().first()
        verify(networkDataSourceMock).fetchRandomGif()
    }
}
