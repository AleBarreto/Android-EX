package com.dev.featurea.di

import com.dev.featurea.data.repository.MovieRepositoryImpl
import com.dev.featurea.data.service.FeatureAService
import com.dev.featurea.data.sources.RemoteMovieDataSource
import com.dev.featurea.domain.repository.MovieRepository
import com.dev.featurea.domain.usecase.GetPopularMoviesUseCase
import com.dev.featurea.navigation.FeatureANavigationImpl
import com.dev.featurea.presentation.viewmodel.FeatureAViewModel
import com.dev.navigation.featureA.FeatureANavigation
import com.dev.network.client.HttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object FeatureAModule {

    fun loadAll() = loadKoinModules(
        listOf(dataModule, domainModule, presentationModule, navigationModule)
    )


    private val dataModule = module {
        factory {
            RemoteMovieDataSource(service = get<HttpClient>().create(FeatureAService::class))
        }
        factory<MovieRepository> { MovieRepositoryImpl(remoteDataSource = get()) }
    }

    private val domainModule = module {
        factory { GetPopularMoviesUseCase(repository = get()) }
    }

    private val presentationModule = module {
        viewModel {
            FeatureAViewModel(
                useCase = get()
            )
        }
    }

    private val navigationModule = module {
        factory<FeatureANavigation> { FeatureANavigationImpl() }
    }
}