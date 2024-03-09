plugins {
    id("multiplatform-setup")
    id(libs.plugins.serialization.get().pluginId)
    id(libs.plugins.sqldelight.get().pluginId)
}

sqldelight {
    databases{
        create("GAMEDBPLAYZONE"){
            packageName.set("com.observer.playzone")
            generateAsync.set(true)
        }
    }
}
kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(libs.kotlinx.serialization.core)
                api(libs.kotlinx.coroutines)
                api(libs.ktor.client.core)
                api(libs.kodein.di)
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
                implementation(libs.sqldelight.android.driver)
                implementation(libs.compose.ui)
            }
        }

        iosMain {
            dependencies {
                implementation(libs.ktor.client.ios)
                implementation(libs.sqldelight.native.driver)
            }
        }

        desktopMain {
            dependencies {
                implementation(libs.ktor.http)
                implementation(libs.ktor.client.okhttp)
                implementation(libs.sqldelight.sqlite.driver)
            }
        }

        jsMain {
            dependencies {
                implementation(libs.sqldelight.js.driver)
                implementation(npm("sql.js", "1.6.2"))
                implementation(devNpm("copy-webpack-plugin", "9.1.0"))
            }
        }
    }
}
android{
    namespace = "com.observer.playzone"
}
