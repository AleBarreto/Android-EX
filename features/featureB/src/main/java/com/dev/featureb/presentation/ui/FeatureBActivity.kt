package com.dev.featureb.presentation.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.commons.glide.setImageTmDbApiWithCollapsingToolbar
import com.dev.commons.lifecycle.observerViewModelWhenStarted
import com.dev.commons.ratingbar.setVoteAverage
import com.dev.featureb.R
import com.dev.featureb.databinding.FeatureBActivityFeatureBBinding
import com.dev.featureb.navigation.EXTRA_INTENT_ID_MOVIE
import com.dev.featureb.presentation.viewmodel.DetailsUiState
import com.dev.featureb.presentation.viewmodel.FeatureBViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeatureBActivity : AppCompatActivity(R.layout.feature_b_activity_feature_b) {

    private val viewModel: FeatureBViewModel by viewModels()
    private val adapter by lazy { AdapterMovieCast() }
    private val binding by lazy { FeatureBActivityFeatureBBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUpToolbar()
        val idMovie = intent.getLongExtra(EXTRA_INTENT_ID_MOVIE, 0)
        viewModel.getDetailsMovieById(idMovie = idMovie)
        observerUiState()
        setUpRecyclerView()
    }

    private fun observerUiState() = observerViewModelWhenStarted {
        viewModel.uiState.collect { uiState ->
            setUpDetailView(uiState)
        }
    }

    private fun setUpDetailView(uiState: DetailsUiState) {
        with(binding) {
            uiState.movieResultDetail?.let { movie ->
                backdrop.setImageTmDbApiWithCollapsingToolbar(movie.backdropPath, collapsingToolbar)
                tvTitle.text = movie.title
                tvAboutMovie.text = movie.overview
                ratingBar.setVoteAverage(movie.voteAverage)
                adapter.submitList(uiState.credits?.cast)
            }
        }
    }

    private fun setUpToolbar() {
        with(binding) {
            setSupportActionBar(toolbar)
            collapsingToolbar.isTitleEnabled = false
            supportActionBar?.setDisplayShowTitleEnabled(false)
        }
    }

    private fun setUpRecyclerView() {
        with(binding) {
            rvCast.layoutManager = LinearLayoutManager(
                this@FeatureBActivity,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            rvCast.adapter = adapter
        }
    }
}