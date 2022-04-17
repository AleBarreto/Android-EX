package com.dev.featureb.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class Credits(
    val id: Long,
    val cast: List<Cast>
) : Parcelable

@Parcelize
internal data class Cast(
    val id: Long,
    val name: String,
    val originalName: String,
    val profilePath: String,
) : Parcelable