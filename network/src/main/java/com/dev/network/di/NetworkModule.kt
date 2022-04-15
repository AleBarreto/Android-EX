package com.dev.network.di

import com.dev.network.client.HttpClient
import com.dev.network.client.HttpClientImpl
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object NetworkModule {

    fun load() = loadKoinModules(httpClient)

    private val httpClient = module {
        factory<HttpClient> { HttpClientImpl() }
    }
}