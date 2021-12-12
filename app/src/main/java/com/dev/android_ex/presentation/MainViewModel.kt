package com.dev.android_ex.presentation

import androidx.lifecycle.ViewModel
import com.dev.android_ex.domain.usecase.GetPopularMoviesUseCase

class MainViewModel(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
) : ViewModel() {
}