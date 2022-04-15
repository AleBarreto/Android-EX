package com.dev.network.interceptor

import com.dev.network.BuildConfig
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

private const val API_KEY = "api_key"


internal class DefaultQueryParameterInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestOriginal: Request = chain.request()
        val url: HttpUrl = requestOriginal.url.newBuilder()
            .addQueryParameter(API_KEY, BuildConfig.API_KEY_TMDB).build()
        val request = requestOriginal.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}
