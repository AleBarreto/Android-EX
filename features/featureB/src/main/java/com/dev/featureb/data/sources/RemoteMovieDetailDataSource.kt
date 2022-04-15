package com.dev.featureb.data.sources

import com.dev.featureb.data.model.response.MovieResultDetailResponse
import com.dev.featureb.data.service.FeatureBService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class RemoteMovieDetailDataSource(
    private val service: FeatureBService
) {
    fun getMovieDetail(idMovie: Long): Flow<MovieResultDetailResponse> = flow {
        emit(service.getMovieDetail(idMovie = idMovie))
    }
}