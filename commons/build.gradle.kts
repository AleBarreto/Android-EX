plugins {
    id("commons.android-base-library")
    id("dagger.hilt.android.plugin")
}

dependencies {
    implementation(LifecycleKtx.get())

    implementation(AndroidX.palette)
    implementation(Glide.get())
    kapt(Glide.getProcessor())

    RetrofitConfig.loadAll().forEach { implementation(it) }

    Coroutines.loadAll().forEach { implementation(it) }

    Google.loadAll().forEach { implementation(it) }
    kapt(Google.hiltCompiler)
}