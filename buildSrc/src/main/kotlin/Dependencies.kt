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

object Google {
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val material = "com.google.android.material:material:${Versions.materialDesign}"
    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltAndroid}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hiltCompiler}"

    fun loadAll() = listOf(
        gson, material, hiltAndroid
    )
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