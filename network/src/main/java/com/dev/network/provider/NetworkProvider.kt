package com.dev.network.provider

import com.dev.network.BuildConfig
import com.dev.network.Connection
import com.dev.network.interceptor.DefaultQueryParameterInterceptor
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

internal object NetworkProvider {

    val serviceGenerator: Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL_TMDB)
            .client(okHttp)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()

    private val loggingInterceptor: HttpLoggingInterceptor
        get() = HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
        }

    private val okHttp: OkHttpClient
        get() = OkHttpClient.Builder()
            .connectTimeout(Connection.TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(Connection.Read.TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(Connection.Write.TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .addInterceptor(DefaultQueryParameterInterceptor())
            .build()
}
