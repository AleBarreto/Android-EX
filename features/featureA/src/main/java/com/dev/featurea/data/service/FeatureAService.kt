package com.dev.featurea.data.service

import com.dev.featurea.data.model.response.MovieResultResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface FeatureAService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("language")
        language: String = "pt-BR"
    ): MovieResultResponse
}
