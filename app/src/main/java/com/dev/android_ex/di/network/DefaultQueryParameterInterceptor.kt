package com.dev.android_ex.di.network

import com.dev.android_ex.BuildConfig
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

private const val API_KEY = "api_key"

/**
 * Based https://futurestud.io/tutorials/retrofit-2-how-to-add-query-parameters-to-every-request
 */
class DefaultQueryParameterInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestOriginal: Request = chain.request()
        val url: HttpUrl = requestOriginal.url.newBuilder()
            .addQueryParameter(API_KEY, BuildConfig.API_KEY_TMDB).build()
        val request = requestOriginal.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}
