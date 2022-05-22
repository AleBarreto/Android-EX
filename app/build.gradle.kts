
plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
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
        getByName("debug") {

        }
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
    AndroidX.loadAll().forEach { implementation(it) }

    Features.loadAll().forEach { implementation(project(it)) }

    implementation(project(Network.get()))
    implementation(project(Navigation.get()))

    Google.loadAll().forEach { implementation(it) }
    kapt(Google.hiltCompiler)

    Coroutines.loadAll().forEach { implementation(it) }

    JUnit.loadAll().forEach { testImplementation(it) }

    AndroidTest.loadAll().forEach { androidTestImplementation(it) }
}