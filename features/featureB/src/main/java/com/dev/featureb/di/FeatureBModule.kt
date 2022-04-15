package com.dev.featureb.di

import com.dev.featureb.data.repository.MovieDetailRepositoryImpl
import com.dev.featureb.data.service.FeatureBService
import com.dev.featureb.data.sources.RemoteMovieDetailDataSource
import com.dev.featureb.domain.repository.MovieDetailRepository
import com.dev.featureb.domain.usecase.MovieDetailUseCase
import com.dev.featureb.navigation.FeatureBNavigationImpl
import com.dev.featureb.presentation.FeatureBViewModel
import com.dev.navigation.featureB.FeatureBNavigation
import com.dev.network.client.HttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object FeatureBModule {

    fun loadAll() = loadKoinModules(
        listOf(dataModule, domainModule, presentationModule, navigationModule)
    )

    private val dataModule = module {
        factory {
            RemoteMovieDetailDataSource(service = get<HttpClient>().create(FeatureBService::class))
        }
        factory<MovieDetailRepository> { MovieDetailRepositoryImpl(remoteDataSource = get()) }
    }

    private val domainModule = module {
        factory { MovieDetailUseCase(repository = get()) }
    }

    private val presentationModule = module {
        viewModel { FeatureBViewModel(useCase = get()) }
    }

    private val navigationModule = module {
        factory<FeatureBNavigation> { FeatureBNavigationImpl() }
    }
}