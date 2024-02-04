plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

kotlin {
    jvm()
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }
    sourceSets{
        commonMain.dependencies {
            implementation(compose.foundation)
            implementation(compose.material)
        }
        androidMain.dependencies {
            implementation(Dependencies.Android.Compose.ui)
            implementation(Dependencies.Android.Compose.material)
            implementation(Dependencies.Android.Compose.tooling)
            implementation(Dependencies.Android.Compose.icons)
            implementation(Dependencies.Android.composeActivity)

        }
        jvmMain.dependencies {
            implementation(compose.desktop.common)
        }
    }
}
android {
    namespace = "com.observer.playzone"
    compileSdk = 34
    defaultConfig {
        minSdk = 26
    }
}