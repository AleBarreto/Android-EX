package com.dev.android_ex.domain.repository

import com.dev.android_ex.domain.model.MovieResult
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getPopularMovies(): Flow<MovieResult>
}
