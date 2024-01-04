import org.gradle.kotlin.dsl.kotlin

plugins{
    id("com.android.library")
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}
kotlin{
    jvm()
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    sourceSets{
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
        }
        androidMain.dependencies {

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
        minSdk = 23
    }
}