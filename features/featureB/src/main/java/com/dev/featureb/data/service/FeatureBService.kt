package com.dev.featureb.data.service

import com.dev.featureb.data.model.response.MovieResultDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface FeatureBService {

    @GET("movie/{id}")
    suspend fun getMovieDetail(
        @Path("id")
        idMovie: Long,
        @Query("language")
        language: String = "pt-BR"
    ): MovieResultDetailResponse
}
