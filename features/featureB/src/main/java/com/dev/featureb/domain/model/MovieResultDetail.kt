package com.dev.featureb.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieResultDetail(
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
