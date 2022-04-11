plugins {
    id("commons.android-base-feature")
}

android {
    resourcePrefix = "featureA"
}

dependencies {
    // module specific dependencies
    implementation(project(Navigation.get()))
}