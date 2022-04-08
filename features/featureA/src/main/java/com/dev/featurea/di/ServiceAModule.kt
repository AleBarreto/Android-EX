package com.dev.featurea.di

import com.dev.featurea.data.service.FeatureAService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
internal object ServiceAModule {

    @Provides
    fun provideFeatureAService(retrofit: Retrofit): FeatureAService =
        retrofit.create(FeatureAService::class.java)
}
