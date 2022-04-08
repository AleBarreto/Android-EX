package com.dev.featurea.data.sources

import com.dev.featurea.data.model.response.MovieResultResponse
import com.dev.featurea.data.service.FeatureAService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class RemoteMovieDataSource @Inject constructor(private val service: FeatureAService) {

    fun getPopularMovies(): Flow<MovieResultResponse> = flow {
        emit(service.getPopularMovies())
    }
}
