package com.dev.android_ex.domain.usecase

import com.dev.android_ex.domain.repository.MovieRepository

class GetPopularMoviesUseCase(
    private val repository: MovieRepository
) {
    operator fun invoke() = repository.getPopularMovies()
}