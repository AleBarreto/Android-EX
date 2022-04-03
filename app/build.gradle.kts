plugins {
    id("com.android.application")
    id ("kotlin-android")
    id ("kotlin-parcelize")
    id ("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

apply(from = "${rootDir}/config/ktlint/klint.gradle.kts")
apply(from = "${rootDir}/config/detekt/detekt.gradle.kts")

android {
    compileSdk = BuildConfig.COMPILE_SDK
    defaultConfig {
        applicationId = BuildConfig.APPLICATION_ID
        minSdk = BuildConfig.MIN_SDK
        targetSdk = BuildConfig.TARGET_SDK
        versionCode = BuildConfig.VERSION_CODE
        versionName = BuildConfig.VERSION_NAME
        testInstrumentationRunner = BuildConfig.TEST_INSTRUMENTATION_RUNNER
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    AndroidX.loadAll().forEach { implementation(it) }

    Google.loadAll().forEach { implementation(it) }
    kapt(Google.hiltCompiler)

    Coroutines.loadAll().forEach { implementation(it) }

    JUnit.loadAll().forEach { testImplementation(it) }

    AndroidTest.loadAll().forEach { androidTestImplementation(it) }
}