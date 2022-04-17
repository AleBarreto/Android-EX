package com.dev.commons.glide

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.annotation.Nullable
import androidx.palette.graphics.Palette
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.google.android.material.appbar.CollapsingToolbarLayout

fun ImageView.setImageTmDbApi(size: String, urlPath: String) {
    Glide.with(this.context)
        .load("https://image.tmdb.org/t/p/w$size$urlPath")
        .transition(DrawableTransitionOptions.withCrossFade())
        .centerCrop()
        .into(this)
}

fun ImageView.setImageTmDbApiCircle(size: String, urlPath: String) {
    Glide.with(this.context)
        .load("https://image.tmdb.org/t/p/w$size$urlPath")
        .circleCrop()
        .into(this)
}

fun ImageView.setImageTmDbApiWithCollapsingToolbar(
    path: String,
    collapsingToolbar: CollapsingToolbarLayout
) {
    Glide.with(this.context).asBitmap().load("https://image.tmdb.org/t/p/w500$path")
        .into(object : CustomTarget<Bitmap?>() {
            override fun onResourceReady(
                resource: Bitmap,
                @Nullable transition: Transition<in Bitmap?>?
            ) {
                this@setImageTmDbApiWithCollapsingToolbar.setImageBitmap(resource)
                val palette = Palette.from(resource).generate()
                collapsingToolbar.setContentScrimColor(palette.getMutedColor(Color.BLACK))
                collapsingToolbar.setStatusBarScrimColor(palette.getDarkMutedColor(Color.BLACK))
            }

            override fun onLoadCleared(@Nullable placeholder: Drawable?) {}
        })

}
