package com.dev.featurea.di

import com.dev.featurea.data.repository.MovieRepositoryImpl
import com.dev.featurea.data.sources.RemoteMovieDataSource
import com.dev.featurea.data.sources.RemoteMovieDataSourceImpl
import com.dev.featurea.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class DataModule {

    @Binds
    abstract fun bindMovieRepository(
        movieRepositoryImpl: MovieRepositoryImpl
    ): MovieRepository

    @Binds
    abstract fun bindMovieRemoteDataSource(
        remoteMovieDataSourceImpl: RemoteMovieDataSourceImpl
    ): RemoteMovieDataSource
}
