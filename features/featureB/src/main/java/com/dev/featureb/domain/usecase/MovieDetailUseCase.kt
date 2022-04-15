package com.dev.featureb.domain.usecase

import com.dev.featureb.domain.model.MovieResultDetail
import com.dev.featureb.domain.repository.MovieDetailRepository
import kotlinx.coroutines.flow.Flow

internal class MovieDetailUseCase(
    private val repository: MovieDetailRepository
) {
    operator fun invoke(idMovie: Long): Flow<MovieResultDetail> =
        repository.getMovieDetail(idMovie = idMovie)
}