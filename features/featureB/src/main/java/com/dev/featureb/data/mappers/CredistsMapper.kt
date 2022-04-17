package com.dev.featureb.data.mappers

import com.dev.featureb.data.model.response.CastResponse
import com.dev.featureb.data.model.response.CreditsResponse
import com.dev.featureb.domain.model.Cast
import com.dev.featureb.domain.model.Credits

internal fun CastResponse.toDomain() = Cast(
    id = id,
    originalName = originalName,
    profilePath = profilePath.orEmpty(),
    name = name
)

internal fun CreditsResponse.toDomain() = Credits(
    id = id,
    cast = cast.map { it.toDomain() }
)