package com.dev.featureb.presentation.viewmodel

import com.dev.featureb.domain.model.Credits
import com.dev.featureb.domain.model.MovieResultDetail

internal data class DetailsUiState(
    val isLoading: Boolean = false,
    val hasError: Boolean = false,
    val movieResultDetail: MovieResultDetail? = null,
    val credits: Credits? = null
) {
    fun showLoading() = copy(isLoading = true, hasError = false)
    fun showError() = copy(isLoading = false, hasError = true)
    fun setDetailsState(movieResultDetail: MovieResultDetail, credits: Credits) = copy(
        isLoading = false,
        hasError = false,
        movieResultDetail = movieResultDetail,
        credits = credits
    )
}
