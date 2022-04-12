package com.dev.commons.glide

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

fun ImageView.setImageTmDbApi(size: String, urlPath: String) {
    Glide.with(this.context)
        .load("https://image.tmdb.org/t/p/w$size$urlPath")
        .transition(DrawableTransitionOptions.withCrossFade())
        .centerCrop()
        .into(this)
}
