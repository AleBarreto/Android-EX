package com.dev.featurea.navigation

import android.content.Context
import android.content.Intent
import com.dev.featurea.presentation.FeatureAActivity
import com.dev.navigation.featureA.FeatureANavigation
import javax.inject.Inject

internal class FeatureANavigationImpl @Inject constructor() : FeatureANavigation {
    override fun navigationToFeatureA(context: Context) {
        context.startActivity(Intent(context, FeatureAActivity::class.java))
    }
}
