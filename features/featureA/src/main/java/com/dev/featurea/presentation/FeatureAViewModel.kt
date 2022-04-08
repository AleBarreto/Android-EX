package com.dev.featurea.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.featurea.domain.usecase.GetPopularMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class FeatureAViewModel @Inject constructor(
    private val useCase: GetPopularMoviesUseCase,
) : ViewModel() {

    fun test() {
        viewModelScope.launch {
            useCase()
                .collect {
                    Log.d("ALECOSTA", "collect = $it")
                }
        }
    }
}
