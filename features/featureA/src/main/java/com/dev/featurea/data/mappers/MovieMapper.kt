package com.dev.featurea.data.mappers

import com.dev.featurea.data.model.response.MovieResponse
import com.dev.featurea.data.model.response.MovieResultResponse
import com.dev.featurea.domain.model.Movie
import com.dev.featurea.domain.model.MovieResult

internal fun MovieResponse.toDomain() = Movie(
    adult = adult,
    backdropPath = backdropPath,
    genreIDS = genreIDS,
    id = id,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    posterPath = posterPath,
    releaseDate = releaseDate,
    title = title,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount
)

internal fun MovieResultResponse.toDomain() = MovieResult(
    results = results.map { it.toDomain() }
)
