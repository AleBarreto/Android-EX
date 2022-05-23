package com.dev.featureb.data.sources

import com.dev.featureb.data.model.response.CreditsResponse
import com.dev.featureb.data.model.response.MovieResultDetailResponse
import com.dev.featureb.data.service.FeatureBService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class RemoteMovieDetailDataSourceImpl @Inject constructor(
    private val service: FeatureBService
) : RemoteMovieDetailDataSource {

    override fun getMovieDetail(idMovie: Long): Flow<MovieResultDetailResponse> = flow {
        emit(service.getMovieDetail(idMovie = idMovie))
    }

    override fun getCreditsByMovieId(idMovie: Long): Flow<CreditsResponse> = flow {
        emit(service.getCreditsByMovieId(idMovie))
    }
}
