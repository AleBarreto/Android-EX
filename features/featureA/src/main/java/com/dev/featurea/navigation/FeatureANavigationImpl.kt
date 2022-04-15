package com.dev.featurea.navigation

import android.content.Context
import android.content.Intent
import com.dev.featurea.presentation.ui.FeatureAActivity
import com.dev.navigation.featureA.FeatureANavigation

internal class FeatureANavigationImpl : FeatureANavigation {
    override fun navigationToFeatureA(context: Context) {
        context.startActivity(Intent(context, FeatureAActivity::class.java))
    }
}
