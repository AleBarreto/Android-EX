package com.dev.featurea.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.dev.featurea.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeatureAActivity : AppCompatActivity(R.layout.feature_a_activity_feature_a) {

    private val viewModel: FeatureAViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.test()
    }
}
