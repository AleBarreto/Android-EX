package com.dev.featurea.presentation

import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.dev.featurea.R
import com.dev.navigation.featureB.FeatureBNavigation
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FeatureAActivity : AppCompatActivity(R.layout.feature_a_activity_feature_a) {

    private val viewModel: FeatureAViewModel by viewModels()
    @Inject lateinit var navigation: FeatureBNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.test()
        findViewById<Button>(R.id.btnFeatureB).setOnClickListener {
            navigation.navigationToFeatureB(this,634649)
        }
    }
}
