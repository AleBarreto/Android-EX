package com.dev.featurea.presentation.viewmodel

internal sealed class MovieUiAction {
    data class NavToDetailMovie(val idMovie: Long) : MovieUiAction()
}