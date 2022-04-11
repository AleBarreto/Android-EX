package com.dev.featurea.di

import com.dev.featurea.navigation.FeatureANavigationImpl
import com.dev.navigation.featureA.FeatureANavigation
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class NavigationModule {
    @Binds
    abstract fun bindNavigation(
        featureANavigationImpl: FeatureANavigationImpl
    ): FeatureANavigation
}
