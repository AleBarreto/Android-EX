package com.dev.network.client

import com.dev.network.provider.NetworkProvider
import kotlin.reflect.KClass

internal class HttpClientImpl : HttpClient {

    override fun <SERVICE, KCLASS : KClass<SERVICE>> create(serviceClass: KCLASS): SERVICE =
        NetworkProvider.serviceGenerator.create(serviceClass.java)
}