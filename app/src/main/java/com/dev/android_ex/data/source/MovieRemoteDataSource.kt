package com.dev.android_ex.data.source

import com.dev.android_ex.data.model.response.MovieResponse
import com.dev.android_ex.data.model.response.MovieResultResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor() {

    fun getPopularMovies(): Flow<MovieResultResponse> = fakeDataPopularMovies()

    private fun fakeDataPopularMovies() = flowOf(
        MovieResultResponse(fakeMovies())
    )

    private fun fakeMovies() = listOf(
        MovieResponse(
            adult = false,
            backdropPath = "",
            genreIDS = emptyList(),
            id = 1,
            originalLanguage = "",
            originalTitle = "test",
            overview = "",
            popularity = 10.0,
            posterPath = "",
            releaseDate = "",
            title = "test",
            video = false,
            voteAverage = 10.0,
            voteCount = 1
        )
    )
}
