package com.dev.featureb.data.sources

import com.dev.featureb.data.model.response.CreditsResponse
import com.dev.featureb.data.model.response.MovieResultDetailResponse
import kotlinx.coroutines.flow.Flow

internal interface RemoteMovieDetailDataSource {
    fun getMovieDetail(idMovie: Long): Flow<MovieResultDetailResponse>
    fun getCreditsByMovieId(idMovie: Long): Flow<CreditsResponse>
}
