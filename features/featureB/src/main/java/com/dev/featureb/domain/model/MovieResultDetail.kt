package com.dev.featureb.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieResultDetail(
    val id: Long,
    val title: String,
    val overview: String,
    val backdropPath: String,
    val posterPath: String,
    val voteAverage: Double,
    val genres: List<Genre>,
    val productionCompanies: List<Company>
) : Parcelable

@Parcelize
data class Genre(
    val id: Long,
    val name: String
) : Parcelable

@Parcelize
data class Company(
    val id: Long,
    val logoPath: String,
    val name: String,
    val originCountry: String
) : Parcelable
