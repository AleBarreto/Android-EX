package com.dev.featureb.presentation.ui

import androidx.recyclerview.widget.RecyclerView
import com.dev.commons.glide.setImageTmDbApiCircle
import com.dev.featureb.databinding.FeatureBItemListCastBinding
import com.dev.featureb.domain.model.Cast

private const val SIZE_IMG = "200"

internal class CastViewHolder(binding: FeatureBItemListCastBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private val tvTitle = binding.tvCast
    private val ivCast = binding.ivCast

    fun bind(cast: Cast) {
        with(cast) {
            tvTitle.text = name
            ivCast.setImageTmDbApiCircle(size = SIZE_IMG, urlPath = profilePath)
        }
    }
}