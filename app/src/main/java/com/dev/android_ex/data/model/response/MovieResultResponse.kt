package com.dev.android_ex.data.model.response

import android.os.Parcelable
import com.dev.android_ex.domain.model.Movie
import com.dev.android_ex.domain.model.MovieResult
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class MovieResultResponse(
    @SerializedName(value = "results")
    val results: List<MovieResponse>
)

@Parcelize
data class MovieResponse(
    @SerializedName(value = "adult")
    val adult: Boolean,
    @SerializedName(value = "backdrop_path")
    val backdropPath: String,
    @SerializedName(value = "genre_ids")
    val genreIDS: List<Long>,
    @SerializedName(value = "id")
    val id: Long,
    @SerializedName(value = "original_language")
    val originalLanguage: String,
    @SerializedName(value = "original_title")
    val originalTitle: String,
    @SerializedName(value = "overview")
    val overview: String,
    @SerializedName(value = "popularity")
    val popularity: Double,
    @SerializedName(value = "poster_path")
    val posterPath: String,
    @SerializedName(value = "release_date")
    val releaseDate: String,
    @SerializedName(value = "title")
    val title: String,
    @SerializedName(value = "video")
    val video: Boolean,
    @SerializedName(value = "vote_average")
    val voteAverage: Double,
    @SerializedName(value = "vote_count")
    val voteCount: Long
) : Parcelable

fun MovieResultResponse.toMovieResult() =
    MovieResult(
        results = results.map { movieResponse ->
            movieResponse.toMovie()
        }
    )

private fun MovieResponse.toMovie() =
    Movie(
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
