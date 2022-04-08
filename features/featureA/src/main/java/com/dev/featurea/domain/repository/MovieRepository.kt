package com.dev.featurea.domain.repository

import com.dev.featurea.domain.model.MovieResult
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getPopularMovies(): Flow<MovieResult>
}
