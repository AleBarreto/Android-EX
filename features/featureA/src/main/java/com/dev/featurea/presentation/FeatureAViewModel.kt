package com.dev.featurea.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.commons.coroutine.di.DispatchersIo
import com.dev.featurea.domain.usecase.GetPopularMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class FeatureAViewModel @Inject constructor(
    private val useCase: GetPopularMoviesUseCase,
    @DispatchersIo private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    fun test() {
        viewModelScope.launch {
            useCase()
                .flowOn(dispatcher)
                .collect {
                    Log.d("ALECOSTA", "collect = $it")
                }
        }
    }
}
