package com.dev.featureb.data.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieResultDetailResponse(
    @SerializedName(value = "genres")
    val genres: List<GenreResponse>,
    @SerializedName(value = "production_companies")
    val productionCompanies: List<CompanyResponse>
) : Parcelable

@Parcelize
data class GenreResponse(
    @SerializedName(value = "id")
    val id: Long,
    @SerializedName(value = "name")
    val name: String
) : Parcelable

@Parcelize
data class CompanyResponse(
    @SerializedName(value = "id")
    val id: Long,
    @SerializedName(value = "logo_path")
    val logoPath: String,
    @SerializedName(value = "name")
    val name: String,
    @SerializedName(value = "origin_country")
    val originCountry: String
) : Parcelable
