package com.dev.featureb.data.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CreditsResponse(
    @SerializedName("id")
    val id: Long,
    @SerializedName("cast")
    val cast: List<CastResponse>
) : Parcelable

@Parcelize
data class CastResponse(
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("original_name")
    val originalName: String,
    @SerializedName("profile_path")
    val profilePath: String? = null,
) : Parcelable