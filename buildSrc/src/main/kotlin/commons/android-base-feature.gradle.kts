package commons

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}

@Suppress("UnstableApiUsage")
android {
    compileSdk = BuildConfig.COMPILE_SDK
    defaultConfig {
        minSdk = BuildConfig.MIN_SDK
        targetSdk = BuildConfig.TARGET_SDK
        testInstrumentationRunner = BuildConfig.TEST_INSTRUMENTATION_RUNNER
        consumerProguardFiles("proguard-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

dependencies {
    implementation(project(Commons.get()))
    AndroidX.loadAll().forEach { implementation(it) }
    implementation(RetrofitConfig.retrofit)
    Google.loadAll().forEach { implementation(it) }
    kapt(Google.hiltCompiler)
    JUnit.loadAll().forEach { testImplementation(it) }
    AndroidTest.loadAll().forEach { androidTestImplementation(it) }
}