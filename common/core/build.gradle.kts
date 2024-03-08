plugins {
    id("multiplatform-setup")
    id(libs.plugins.serialization.get().pluginId)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(libs.kotlinx.serialization.core)
                api(libs.kotlinx.coroutines)
                api(libs.ktor.client.core)
                api(libs.kodein.di)
               // api(libs.sqldelight.sqlite.driver)
                implementation(libs.ktor.client.json)
                implementation(libs.ktor.client.serialization)
                implementation(libs.ktor.client.negotiation)
                implementation(libs.ktor.client.logging)
                implementation(libs.multiplatform.settings.core)
                implementation(libs.multiplatform.settings.no.arg)
            }
        }

        androidMain {
            dependencies {
                implementation(libs.ktor.client.android)
               // implementation(libs.sqldelight.android.driver)
                implementation(libs.compose.ui)
            }
        }

        iosMain {
            dependencies {
                implementation(libs.ktor.client.ios)
             //   implementation(libs.sqldelight.native.driver)
            }
        }

        desktopMain {
            dependencies {
                implementation(libs.ktor.http)
              //  implementation(libs.sqldelight.coroutines.extensions)
            }
        }
    }
}
android{
    namespace = "com.observer.playzone"
}
