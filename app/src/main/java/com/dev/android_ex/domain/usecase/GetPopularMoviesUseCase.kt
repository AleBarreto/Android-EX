package com.dev.android_ex.domain.usecase

import com.dev.android_ex.domain.repository.MovieRepository
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke() = repository.getPopularMovies()
}
