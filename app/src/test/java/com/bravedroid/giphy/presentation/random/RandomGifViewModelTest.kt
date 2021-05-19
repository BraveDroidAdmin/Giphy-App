package com.bravedroid.giphy.presentation.random

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateHandle
import com.bravedroid.giphy.domain.Gif
import com.bravedroid.giphy.domain.usecase.GetRandomGifUseCase
import com.bravedroid.giphy.infrastructure.util.CoroutineTestRule
import com.bravedroid.giphy.presentation.RandomGifViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

@ExperimentalCoroutinesApi
@Suppress("UNCHECKED_CAST")
class RandomGifViewModelTest {

    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Rule
    @JvmField
    var coroutineTestRule = CoroutineTestRule()

    lateinit var sut: RandomGifViewModel
    lateinit var getRandomGifUseCaseMock: GetRandomGifUseCase
    lateinit var saveStateHandle: SavedStateHandle

    @Before
    fun setUp() {
    }

    @Test
    fun getGifUrl() {
        val gif = flowOf(Gif("test"))
        getRandomGifUseCaseMock = mock(GetRandomGifUseCase::class.java)
        saveStateHandle = mock(SavedStateHandle::class.java)
        sut = RandomGifViewModel(saveStateHandle, getRandomGifUseCaseMock)
        `when`(getRandomGifUseCaseMock.invoke()).thenReturn(gif)
        val observerMock = mock(Observer::class.java) as Observer<String>

        sut.randomGifUrl.observeForever(observerMock)
        sut.loadRandomGifContent()

        verify(observerMock).onChanged("test")
    }
}
