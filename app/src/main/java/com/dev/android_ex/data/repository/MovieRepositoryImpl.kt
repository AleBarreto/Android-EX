package com.dev.android_ex.data.repository

import com.dev.android_ex.data.model.response.toMovieResult
import com.dev.android_ex.data.source.MovieRemoteDataSource
import com.dev.android_ex.domain.repository.MovieRepository
import com.dev.android_ex.domain.model.MovieResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieRepositoryImpl(private val source: MovieRemoteDataSource) : MovieRepository {
    override fun getPopularMovies(): Flow<MovieResult> =
        source.getPopularMovies().map { movieResultResponse ->
            movieResultResponse.toMovieResult()
        }
}
