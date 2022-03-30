package com.dev.android_ex.di

import com.dev.android_ex.data.repository.MovieRepositoryImpl
import com.dev.android_ex.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindRepository(
        movieRepositoryImpl: MovieRepositoryImpl
    ): MovieRepository

}