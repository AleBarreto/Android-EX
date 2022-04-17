package com.dev.featureb.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.commons.coroutine.di.DispatchersIo
import com.dev.featureb.domain.model.Credits
import com.dev.featureb.domain.model.MovieResultDetail
import com.dev.featureb.domain.usecase.GetCreditsByMovieIdUseCase
import com.dev.featureb.domain.usecase.GetMovieDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class FeatureBViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
    private val getCreditsByMovieIdUseCase: GetCreditsByMovieIdUseCase,
    @DispatchersIo private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _uiState = MutableStateFlow(DetailsUiState())
    val uiState: StateFlow<DetailsUiState> = _uiState.asStateFlow()

    fun getDetailsMovieById(idMovie: Long) {
        showLoading()
        viewModelScope.launch(dispatcher) {
            try {
                val movieDetail = getMovieDetailUseCase(idMovie)
                val credits = getCreditsByMovieIdUseCase(idMovie)
                setDetailsState(movieResultDetail = movieDetail, credits = credits)
            } catch (e: Exception) {
                setError()
            }
        }
    }

    private fun showLoading() =
        _uiState.update { it.copy(isLoading = true) }

    private fun setError() = _uiState.update { it.copy(isLoading = false, hasError = true) }

    private fun setDetailsState(movieResultDetail: MovieResultDetail, credits: Credits) =
        _uiState.update {
            it.copy(
                movieResultDetail = movieResultDetail,
                credits = credits,
                isLoading = false
            )
        }
}