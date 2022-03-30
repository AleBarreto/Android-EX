package com.dev.android_ex.data.repository

import com.dev.android_ex.data.model.response.toMovieResult
import com.dev.android_ex.data.source.MovieRemoteDataSource
import com.dev.android_ex.domain.model.MovieResult
import com.dev.android_ex.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val source: MovieRemoteDataSource
) : MovieRepository {
    override fun getPopularMovies(): Flow<MovieResult> =
        source.getPopularMovies().map { movieResultResponse ->
            movieResultResponse.toMovieResult()
        }
}
