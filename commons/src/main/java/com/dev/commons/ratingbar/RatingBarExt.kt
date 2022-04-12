package com.dev.commons.ratingbar

import android.widget.RatingBar

fun RatingBar.setVoteAverage(value: Double) {
    this.rating = (value / 2).toFloat()
}