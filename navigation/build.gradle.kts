plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = BuildConfig.COMPILE_SDK
    defaultConfig {
        minSdk = BuildConfig.MIN_SDK
        targetSdk = BuildConfig.TARGET_SDK
        testInstrumentationRunner = BuildConfig.TEST_INSTRUMENTATION_RUNNER
        consumerProguardFiles("proguard-rules.pro")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}