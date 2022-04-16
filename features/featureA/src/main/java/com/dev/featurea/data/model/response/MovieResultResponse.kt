package com.dev.featurea.data.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieResultResponse(
    @SerializedName(value = "results")
    val results: List<MovieResponse>
) : Parcelable

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
    val posterPath: String? = null,
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
