package com.bravedroid.giphy.presentation.random

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.bravedroid.giphy.domain.usecase.GetRandomGifUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class RandomGifViewModel @ViewModelInject constructor(
    @Assisted private val saveStateHandle: SavedStateHandle,
    private val getRandomGifUseCase: GetRandomGifUseCase,
) : ViewModel() {

    private val _gifUrl = MutableLiveData<String>()
    val gifUrl: LiveData<String> = _gifUrl

    fun loadContent() {
        viewModelScope.launch {
            getRandomGifUseCase.invoke().collect {
                _gifUrl.value = it.url
            }
        }
    }
}
