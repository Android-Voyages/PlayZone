import org.gradle.api.JavaVersion
import org.gradle.api.artifacts.dsl.Dependencies

plugins {
    id("com.android.library")
}

android {
    compileSdk = 34

    defaultConfig {
        minSdk = 26
        targetSdk = 34
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = DependenciesVersion.Compose.composeCompilier
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    sourceSets {
        named("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
            res.srcDirs("src/androidMain/res", "src/commonMain/resources")

        }
    }
}