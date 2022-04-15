object AndroidX {
    const val coreKtx = "androidx.core:core-ktx:${Versions.androidXCore}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtx}"
    const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModelKtx}"

    fun loadAll() = listOf(
        coreKtx, appCompat, constraintLayout, activityKtx, viewModelKtx
    )
}

object Features {
    const val featureA = ":features:featureA"
    const val featureB = ":features:featureB"

    fun loadAll() = listOf(
        featureA, featureB
    )
}

object Network {
    private const val network = ":network"
    fun get() = network
}

object Commons {
    private const val commons = ":commons"
    fun get() = commons
}

object Navigation {
    private const val navigation = ":navigation"
    fun get() = navigation
}

object Google {
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val material = "com.google.android.material:material:${Versions.materialDesign}"

    fun loadAll() = listOf(
        gson, material
    )
}

object Koin {
    private val koin = "io.insert-koin:koin-android:${Versions.koin}"
    fun get() = koin
}

object Coroutines {
    const val coroutineCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCore}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroid}"

    fun loadAll() = listOf(
        coroutineCore, coroutinesAndroid
    )
}

object LifecycleKtx {
    private const val lifecycleKtx =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleKtx}"

    fun get() = lifecycleKtx
}

object Glide {
    private const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    private const val glideProcessor = "com.github.bumptech.glide:compiler:${Versions.glide}"
    fun get() = glide
    fun getProcessor() = glideProcessor
}

object RetrofitConfig {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.gsonConvert}"
    const val logInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.logInterceptor}"

    fun loadAll() = listOf(
        retrofit, converterGson, logInterceptor
    )
}

object JUnit {
    const val jUnit = "junit:junit:${Versions.jUnit}"
    fun loadAll() = listOf(
        jUnit
    )
}

object AndroidTest {
    const val extJUnit = "androidx.test.ext:junit:${Versions.jUnitExt}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    fun loadAll() = listOf(
        extJUnit,
        espressoCore
    )
}