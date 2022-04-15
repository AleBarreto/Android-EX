package com.dev.featurea.domain.usecase

import com.dev.featurea.domain.model.MovieResult
import com.dev.featurea.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

internal class GetPopularMoviesUseCase(private val repository: MovieRepository) {
    operator fun invoke(): Flow<MovieResult> = repository.getPopularMovies()
}
