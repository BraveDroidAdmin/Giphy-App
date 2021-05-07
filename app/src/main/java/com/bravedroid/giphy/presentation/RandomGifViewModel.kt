package com.bravedroid.giphy.presentation

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.bravedroid.giphy.domain.usecase.GetGifsUseCase
import com.bravedroid.giphy.domain.usecase.GetRandomGifUseCase
import com.bravedroid.giphy.util.Logger
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class RandomGifViewModel @ViewModelInject constructor(
    @Assisted private val saveStateHandle: SavedStateHandle,
    private val getRandomGifUseCase: GetRandomGifUseCase,
    private val getGifsUseCase: GetGifsUseCase,
    private val logger: Logger,
) : ViewModel() {

    private val _gifUrl = MutableLiveData<String>()
    val gifUrl: LiveData<String> = _gifUrl

    private val _gifsUrl = MutableLiveData<List<GifUiModel>>()
    val gifsUrl: LiveData<List<GifUiModel>> = _gifsUrl

    fun loadContent() {
        viewModelScope.launch {
            getRandomGifUseCase.invoke()
                .catch { cause ->
                    logger.logError(cause.message.toString(), "getRandomGifUseCase" )
                }
                .collect {
                _gifUrl.value = it.url
            }

            getGifsUseCase.invoke().collect { list ->
                val gifsList = mutableListOf<GifUiModel>()
                list.forEach {
                    gifsList.add(GifUiModel(it.url))
                }
                _gifsUrl.value = gifsList
            }
        }
    }
}
