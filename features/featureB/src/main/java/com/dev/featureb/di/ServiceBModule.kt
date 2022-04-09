package com.dev.featureb.di

import com.dev.featureb.data.service.FeatureBService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
internal object ServiceBModule {
    @Provides
    fun provideFeatureBService(retrofit: Retrofit): FeatureBService =
        retrofit.create(FeatureBService::class.java)
}
