plugins {
    id("commons.android-base-feature")
}

android {
    resourcePrefix = "featureB"
}

dependencies {
    // module specific dependencies
    implementation(project(Navigation.get()))
}