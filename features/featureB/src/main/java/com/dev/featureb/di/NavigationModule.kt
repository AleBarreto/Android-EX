package com.dev.featureb.di

import com.dev.featureb.navigation.FeatureBNavigationImpl
import com.dev.navigation.featureB.FeatureBNavigation
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class NavigationModule {

    @Binds
    abstract fun bindNavigation(
        featureBNavigationImpl: FeatureBNavigationImpl
    ): FeatureBNavigation
}