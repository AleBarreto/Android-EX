plugins {
    id("commons.android-base-feature")
}

android {
    resourcePrefix = "featureA"
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // module specific dependencies
    implementation(project(Navigation.get()))
    implementation(project(Network.get()))
}