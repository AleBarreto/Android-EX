package com.dev.featureb.domain.usecase

import com.dev.featureb.domain.model.MovieResultDetail
import com.dev.featureb.domain.repository.MovieDetailRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class MovieDetailUseCase @Inject constructor(
    private val repository: MovieDetailRepository
) {
    operator fun invoke(idMovie: Long): Flow<MovieResultDetail> = repository.getMovieDetail(
        idMovie = idMovie
    )
}