package com.dev.featureb.domain.repository

import com.dev.featureb.domain.model.MovieResultDetail
import kotlinx.coroutines.flow.Flow

internal interface MovieDetailRepository {
    fun getMovieDetail(idMovie: Long): Flow<MovieResultDetail>
}