package com.dev.featureb.domain.usecase

import com.dev.featureb.domain.repository.MovieDetailRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

internal class GetMovieDetailUseCase @Inject constructor(
    private val repository: MovieDetailRepository
) {
    suspend operator fun invoke(idMovie: Long) =
        repository.getMovieDetail(idMovie).first()
}