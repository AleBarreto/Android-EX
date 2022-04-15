package com.dev.featurea.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dev.commons.lifecycle.observerViewModelWhenStarted
import com.dev.featurea.R
import com.dev.featurea.databinding.FeatureAActivityFeatureABinding
import com.dev.featurea.presentation.viewmodel.FeatureAViewModel
import com.dev.featurea.presentation.viewmodel.MovieUiAction
import com.dev.featurea.presentation.viewmodel.MovieUiState
import com.dev.navigation.featureB.FeatureBNavigation
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class FeatureAActivity : AppCompatActivity(R.layout.feature_a_activity_feature_a) {


    private val navigation: FeatureBNavigation by inject()
    private val viewModel: FeatureAViewModel by viewModel()

    private val adapter by lazy { AdapterMovie() }
    private val binding by lazy { FeatureAActivityFeatureABinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupRecyclerView()
        observerUiState()
        observerUiAction()
        viewModel.getPopularMovies()
    }

    private fun observerUiState() = observerViewModelWhenStarted {
        viewModel.uiState.collect { uiState ->
            setupMovieUiState(uiState)
        }
    }

    private fun observerUiAction() = observerViewModelWhenStarted {
        viewModel.uiAction.collect { uiAction ->
            when (uiAction) {
                is MovieUiAction.NavToDetailMovie -> {
                    navigationToMovieDetail(id = uiAction.idMovie)
                }
            }
        }
    }

    private fun navigationToMovieDetail(id: Long) {
        navigation.navigationToFeatureB(this, idMovie = id)
    }

    private fun setupMovieUiState(uiState: MovieUiState) {
        adapter.submitList(uiState.movies)
        // error = uiState.hasError
        // loading = uiState.isLoading
    }

    private fun setupRecyclerView() {
        binding.rvMainList.adapter = adapter
        adapter.onClickList = { id ->
            viewModel.onClickItemList(idMovie = id)
        }
    }
}
