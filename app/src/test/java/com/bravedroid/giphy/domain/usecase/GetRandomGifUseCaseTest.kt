package com.bravedroid.giphy.domain.usecase

import com.bravedroid.giphy.domain.Gif
import com.bravedroid.giphy.domain.repository.GifRepository
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

@ExperimentalCoroutinesApi
class GetRandomGifUseCaseTest {

    lateinit var gifRepositoryMock: GifRepository
    lateinit var sut: GetRandomGifUseCase

    @Before
    fun setUp() {
        gifRepositoryMock = mock(GifRepository::class.java)
    }

    @Test
    fun invokeTest() = runBlockingTest {
        val gif = flowOf(Gif("test"))
        `when`(gifRepositoryMock.getRandom()).thenReturn(gif)
        sut = GetRandomGifUseCase(gifRepositoryMock)
        Truth.assertThat(sut.invoke()).isEqualTo(gif)
    }
}
