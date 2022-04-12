package com.dev.featurea.presentation.ui

import androidx.recyclerview.widget.RecyclerView
import com.dev.commons.glide.setImageTmDbApi
import com.dev.commons.ratingbar.setVoteAverage
import com.dev.featurea.databinding.FeatureAItemListBinding
import com.dev.featurea.domain.model.Movie

private const val SIZE_IMAGE = "300"

internal class MovieViewHolder(binding: FeatureAItemListBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private val tvTitle = binding.tvTitleMovie
    private val tvSubTitle = binding.tvSubTitle
    private val root = binding.root
    private val image = binding.ivMovie
    private val ratingBar = binding.ratingBar

    fun bind(movie: Movie, onClickList: (Long) -> Unit) {
        tvTitle.text = movie.title
        tvSubTitle.text = movie.overview
        root.setOnClickListener {
            onClickList.invoke(movie.id)
        }
        image.setImageTmDbApi(size = SIZE_IMAGE, urlPath = movie.posterPath)
        ratingBar.setVoteAverage(movie.voteAverage)
    }
}