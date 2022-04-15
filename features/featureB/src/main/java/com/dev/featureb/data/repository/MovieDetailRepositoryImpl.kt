package com.dev.featureb.data.repository

import com.dev.featureb.data.mappers.toDomain
import com.dev.featureb.data.sources.RemoteMovieDetailDataSource
import com.dev.featureb.domain.model.MovieResultDetail
import com.dev.featureb.domain.repository.MovieDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class MovieDetailRepositoryImpl(
    private val remoteDataSource: RemoteMovieDetailDataSource
) : MovieDetailRepository {
    override fun getMovieDetail(idMovie: Long): Flow<MovieResultDetail> =
        remoteDataSource.getMovieDetail(idMovie = idMovie)
            .map { movieResultDetailResponse ->
                movieResultDetailResponse.toDomain()
            }
}