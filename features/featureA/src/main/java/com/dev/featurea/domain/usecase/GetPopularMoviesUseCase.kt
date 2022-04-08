package com.dev.featurea.domain.usecase

import com.dev.featurea.domain.model.MovieResult
import com.dev.featurea.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class GetPopularMoviesUseCase @Inject constructor(private val repository: MovieRepository) {
    operator fun invoke(): Flow<MovieResult> = repository.getPopularMovies()
}
