package com.dev.featureb.navigation

import android.content.Context
import android.content.Intent
import com.dev.featureb.presentation.FeatureBActivity
import com.dev.navigation.featureB.FeatureBNavigation

internal class FeatureBNavigationImpl : FeatureBNavigation {
    override fun navigationToFeatureB(context: Context, idMovie: Long) {
        context.startActivity(Intent(context, FeatureBActivity::class.java))
    }
}
