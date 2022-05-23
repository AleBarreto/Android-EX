package com.dev.featureb.data.util

import com.dev.featureb.data.model.response.CreditsResponse
import com.dev.featureb.data.model.response.MovieResultDetailResponse

object MockResponse {

    fun fakeMovieResultDetailResponse() = MovieResultDetailResponse(
        id = 1,
        title = "",
        overview = "",
        backdropPath = "",
        voteAverage = 5.0,
        genres = emptyList(),
        productionCompanies = emptyList()
    )

    fun fakeCreditsResponse() = CreditsResponse(id = 1, cast = emptyList())
}