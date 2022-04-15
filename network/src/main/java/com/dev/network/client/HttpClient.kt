package com.dev.network.client

import kotlin.reflect.KClass

interface HttpClient {
    fun <SERVICE, KCLASS : KClass<SERVICE>> create(serviceClass: KCLASS): SERVICE
}
