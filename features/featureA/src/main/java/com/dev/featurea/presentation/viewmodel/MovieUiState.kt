package com.dev.featurea.presentation.viewmodel

import com.dev.featurea.domain.model.Movie

internal data class MovieUiState(
    val isLoading: Boolean = false,
    val hasError: Boolean = false,
    val movies: List<Movie> = listOf()
)
