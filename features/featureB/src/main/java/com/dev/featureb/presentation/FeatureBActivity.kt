package com.dev.featureb.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dev.featureb.R
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class FeatureBActivity : AppCompatActivity(R.layout.feature_b_activity_feature_b) {

    private val viewModel: FeatureBViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.test()
    }
}