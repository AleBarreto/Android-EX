plugins {
    id("commons.android-base-feature")
}

android {
    resourcePrefix = "featureB"
    buildFeatures{
        viewBinding = true
    }
}

dependencies {
    // module specific dependencies
    implementation(project(Navigation.get()))
}