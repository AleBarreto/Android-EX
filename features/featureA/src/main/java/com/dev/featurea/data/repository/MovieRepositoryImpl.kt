package com.dev.featurea.data.repository

import com.dev.featurea.data.mappers.toDomain
import com.dev.featurea.data.sources.RemoteMovieDataSource
import com.dev.featurea.domain.model.MovieResult
import com.dev.featurea.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class MovieRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteMovieDataSource) :
    MovieRepository {
    override fun getPopularMovies(): Flow<MovieResult> =
        remoteDataSource.getPopularMovies().map { it.toDomain() }
}
