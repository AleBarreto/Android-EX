package com.dev.featureb.navigation

import android.content.Context
import android.content.Intent
import com.dev.featureb.presentation.ui.FeatureBActivity
import com.dev.navigation.featureB.FeatureBNavigation
import javax.inject.Inject

const val EXTRA_INTENT_ID_MOVIE = "id_movie"
internal class FeatureBNavigationImpl @Inject constructor() : FeatureBNavigation {
    override fun navigationToFeatureB(context: Context, idMovie: Long) {
        val intent = Intent(context, FeatureBActivity::class.java)
        intent.putExtra(EXTRA_INTENT_ID_MOVIE, idMovie)
        context.startActivity(intent)
    }
}
