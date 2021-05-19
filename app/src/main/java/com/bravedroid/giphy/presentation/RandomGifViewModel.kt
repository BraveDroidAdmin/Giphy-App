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

    private val _randomGifUrl = MutableLiveData<GifUiModel>()
    val randomGifUrl: LiveData<GifUiModel> = _randomGifUrl

    private val _allGifsUrl = MutableLiveData<List<GifUiModel>>()
    val allGifsUrl: LiveData<List<GifUiModel>> = _allGifsUrl

    fun loadRandomGifContent() {
        viewModelScope.launch {
            getRandomGifUseCase.invoke()
                .catch { cause ->
                    logger.logError(cause.message.toString(), "getRandomGifUseCase")
                }
                .collect {
                    _randomGifUrl.value = GifUiModel(it.url)
                }
        }
    }

    fun loadSearchGifsContent(query: String) {
        viewModelScope.launch {
            getGifsUseCase.invoke(query).collect { list ->
                val gifsList = mutableListOf<GifUiModel>()
                list.forEach {
                    gifsList.add(GifUiModel(it.url))
                }
                _allGifsUrl.value = gifsList
            }
        }
    }
}

