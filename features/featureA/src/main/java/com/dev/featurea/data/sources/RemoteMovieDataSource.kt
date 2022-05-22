package com.dev.featurea.data.sources

import com.dev.featurea.data.model.response.MovieResultResponse
import kotlinx.coroutines.flow.Flow

internal interface RemoteMovieDataSource {
    fun getPopularMovies(): Flow<MovieResultResponse>
}
