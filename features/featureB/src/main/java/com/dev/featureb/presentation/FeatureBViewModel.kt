package com.dev.featureb.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.commons.coroutine.di.DispatchersIo
import com.dev.featureb.domain.usecase.MovieDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class FeatureBViewModel @Inject constructor(
    private val useCase: MovieDetailUseCase,
    @DispatchersIo private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    fun test(idMovie: Long = 634649) = viewModelScope.launch {
        useCase(idMovie)
            .flowOn(dispatcher)
            .collect {
                Log.d("ALECOSTA", "MovieDetailUseCase = $it")
            }
    }

}