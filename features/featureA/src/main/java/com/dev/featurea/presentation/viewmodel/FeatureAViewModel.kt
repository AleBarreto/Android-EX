package com.dev.featurea.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.featurea.domain.usecase.GetPopularMoviesUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

internal class FeatureAViewModel(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val useCase: GetPopularMoviesUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(MovieUiState())
    val uiState: StateFlow<MovieUiState> = _uiState.asStateFlow()

    private val _uiAction = MutableSharedFlow<MovieUiAction>()
    val uiAction: SharedFlow<MovieUiAction> = _uiAction.asSharedFlow()

    fun getPopularMovies() {
        viewModelScope.launch {
            useCase()
                .flowOn(dispatcher)
                .onStart { _uiState.update { it.copy(isLoading = true) } }
                .catch { _uiState.update { it.copy(isLoading = false, hasError = true) } }
                .collect { movieResult ->
                    _uiState.update { it.copy(movies = movieResult.results) }
                }
        }
    }

    fun onClickItemList(idMovie: Long) {
        viewModelScope.launch {
            _uiAction.emit(MovieUiAction.NavToDetailMovie(idMovie))
        }
    }
}
