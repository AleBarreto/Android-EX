import com.android.build.api.dsl.LibraryBuildType

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = BuildConfig.COMPILE_SDK
    defaultConfig {
        minSdk = BuildConfig.MIN_SDK
        targetSdk = BuildConfig.TARGET_SDK
        testInstrumentationRunner = BuildConfig.TEST_INSTRUMENTATION_RUNNER
        consumerProguardFiles("proguard-rules.pro")
    }

    buildTypes {
        getByName("debug") {
            loadSecretKeyTmDb()
            loadUrlApiTmDb()
        }
        getByName("release") {
            loadSecretKeyTmDb()
            loadUrlApiTmDb()
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
    RetrofitConfig.loadAll().forEach { implementation(it) }
    Google.loadAll().forEach { implementation(it) }
    kapt(Google.hiltCompiler)
}

fun LibraryBuildType.loadSecretKeyTmDb(fileName: String = "secrets.properties") {
    val value = gradleSecretProperties(rootDir, fileName).getProperty("PROP_API_KEY_TMDB")
    buildConfigField("String", "API_KEY_TMDB", "\"$value\"")
}

fun LibraryBuildType.loadUrlApiTmDb() {
    buildConfigField("String", "BASE_URL_TMDB", "\"https://api.themoviedb.org/3/\"")
}