package com.dev.featureb.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.featureb.domain.usecase.MovieDetailUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

internal class FeatureBViewModel(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val useCase: MovieDetailUseCase,
) : ViewModel() {

    fun test(idMovie: Long = 634649) = viewModelScope.launch {
        useCase(idMovie)
            .flowOn(dispatcher)
            .collect {
                Log.d("ALECOSTA", "MovieDetailUseCase = $it")
            }
    }

}