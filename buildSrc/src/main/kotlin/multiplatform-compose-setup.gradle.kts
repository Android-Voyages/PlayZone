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
            implementation(DependenciesVersion.Android.Compose.ui)
            implementation(DependenciesVersion.Android.Compose.material)
            implementation(DependenciesVersion.Android.Compose.tooling)
            implementation(DependenciesVersion.Android.Compose.icons)
            implementation(DependenciesVersion.Android.composeActivity)

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