package com.dev.featureb.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.dev.featureb.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeatureBActivity : AppCompatActivity(R.layout.feature_b_activity_feature_b) {

    private val viewModel: FeatureBViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
          viewModel.test()
    }
}