plugins {
    id("com.android.library")
    kotlin("multiplatform")
    kotlin("kapt")
}

kotlin {
    jvm("desktop")
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()
}
android {
    namespace = "com.observer.playzone"
    compileSdk = 34
    defaultConfig {
        minSdk = 26
    }
}