plugins {
    id("com.android.application")
    id("org.jetbrains.compose")
    kotlin("android")
}

android {
    namespace = "com.observer.playzone"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.observer.playzone"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion =  DependenciesVersion.Compose.composeCompilier
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation(project(":common:core"))
    implementation(project(":common:games:api"))
    implementation(project(":common:games:data"))
    implementation(project(":common:umbrella-compose"))
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation(DependenciesVersion.Android.AndroidSdk.core)
    implementation(DependenciesVersion.Android.AndroidSdk.lifecycle)
    implementation(DependenciesVersion.Android.AndroidSdk.fragment)
    implementation(DependenciesVersion.Android.Compose.ui)
    implementation(DependenciesVersion.Android.Compose.material)
    implementation(DependenciesVersion.Android.material3)
}