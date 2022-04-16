
plugins {
    id("commons.android-base-library")
    id("dagger.hilt.android.plugin")
}

android {
    buildTypes {
        getByName("debug") {
            setBuildConfigSecurityKeyApiTmDb(rootDir = rootDir)
            setBuildConfigBaseUrlApiTmDb()
        }
        getByName("release") {
            setBuildConfigSecurityKeyApiTmDb(rootDir = rootDir)
            setBuildConfigBaseUrlApiTmDb()
        }
    }
}

dependencies {
    RetrofitConfig.loadAll().forEach { implementation(it) }
    Google.loadAll().forEach { implementation(it) }
    kapt(Google.hiltCompiler)
}