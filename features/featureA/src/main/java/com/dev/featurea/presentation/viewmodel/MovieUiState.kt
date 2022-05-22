package com.dev.featurea.presentation.viewmodel

import com.dev.featurea.domain.model.Movie

internal data class MovieUiState(
    val isLoading: Boolean = false,
    val hasError: Boolean = false,
    val movies: List<Movie> = listOf()
) {
    fun showLoading() = copy(isLoading = true, hasError = false, movies = emptyList())
    fun showMovies(movies: List<Movie>) = copy(isLoading = false, hasError = false, movies = movies)
    fun showError() = copy(isLoading = false, hasError = true, movies = emptyList())
}
