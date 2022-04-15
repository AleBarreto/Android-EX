import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

repositories {
    google()
    mavenCentral()
    maven("https://plugins.gradle.org/m2/")
}

dependencies {
    implementation("com.android.tools.build:gradle:7.1.3")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.20")
    implementation("com.google.dagger:hilt-android-gradle-plugin:2.40.5")
}