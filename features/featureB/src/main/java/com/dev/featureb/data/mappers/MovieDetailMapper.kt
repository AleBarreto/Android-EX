package com.dev.featureb.data.mappers

import com.dev.featureb.data.model.response.CompanyResponse
import com.dev.featureb.data.model.response.GenreResponse
import com.dev.featureb.data.model.response.MovieResultDetailResponse
import com.dev.featureb.domain.model.Company
import com.dev.featureb.domain.model.Genre
import com.dev.featureb.domain.model.MovieResultDetail


internal fun MovieResultDetailResponse.toDomain() = MovieResultDetail(
    id = id,
    title = title,
    overview = overview,
    backdropPath = backdropPath,
    posterPath = posterPath.orEmpty(),
    voteAverage = voteAverage,
    genres = genres.map { it.toDomain() },
    productionCompanies = productionCompanies.map { it.toDomain() }
)

internal fun CompanyResponse.toDomain() = Company(
    id = id,
    logoPath = logoPath.orEmpty(),
    name = name,
    originCountry = originCountry
)

internal fun GenreResponse.toDomain() = Genre(
    id = id,
    name = name
)
