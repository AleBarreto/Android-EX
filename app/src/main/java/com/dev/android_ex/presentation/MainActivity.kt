package com.dev.android_ex.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dev.android_ex.R
import com.dev.navigation.featureA.FeatureANavigation
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var navigation: FeatureANavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // only test
        navigation.navigationToFeatureA(this)
    }
}
