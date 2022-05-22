package com.dev.featurea.presentation.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.dev.commons.lifecycle.observerViewModelWhenStarted
import com.dev.featurea.R
import com.dev.featurea.databinding.FeatureAActivityFeatureABinding
import com.dev.featurea.presentation.viewmodel.FeatureAViewModel
import com.dev.featurea.presentation.viewmodel.MovieUiAction
import com.dev.featurea.presentation.viewmodel.MovieUiState
import com.dev.navigation.featureB.FeatureBNavigation
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FeatureAActivity : AppCompatActivity(R.layout.feature_a_activity_feature_a) {

    @Inject
    lateinit var navigation: FeatureBNavigation
    private val viewModel: FeatureAViewModel by viewModels()

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
        with(uiState) {
            adapter.submitList(movies)
            binding.progress.isVisible = isLoading
            binding.containerError.isVisible = hasError
        }
    }

    private fun setupRecyclerView() {
        binding.rvMainList.adapter = adapter
        adapter.onClickList = { id ->
            viewModel.onClickItemList(idMovie = id)
        }
    }
}
