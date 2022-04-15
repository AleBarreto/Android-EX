package com.dev.android_ex.di

import com.dev.featurea.di.FeatureAModule
import com.dev.featureb.di.FeatureBModule
import com.dev.network.di.NetworkModule

object AppModule {

    fun start() {
        NetworkModule.load()
        FeatureAModule.loadAll()
        FeatureBModule.loadAll()
    }
}
