package com.dev.featureb.navigation

import android.content.Context
import android.content.Intent
import com.dev.featureb.presentation.FeatureBActivity
import com.dev.navigation.featureB.FeatureBNavigation
import javax.inject.Inject

internal class FeatureBNavigationImpl @Inject constructor() : FeatureBNavigation {
    override fun navigationToFeatureB(context: Context, idMovie: Long) {
        context.startActivity(Intent(context, FeatureBActivity::class.java))
    }
}
