plugins {
    id("multiplatform-setup")
    id("android-setup")
    kotlin("plugin.serialization")
    id("com.squareup.sqldelight")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(DependenciesVersion.Kotlin.Serialization.serialization)
                api(DependenciesVersion.Kotlin.Coroutines.core)
                api(DependenciesVersion.Ktor.core)
                implementation(DependenciesVersion.Ktor.json)
                implementation(DependenciesVersion.Ktor.serialization)
                implementation(DependenciesVersion.Ktor.negotiation)
                implementation(DependenciesVersion.Ktor.kotlin_json)
                implementation(DependenciesVersion.Ktor.logging)

                implementation(DependenciesVersion.Settings.core)
                implementation(DependenciesVersion.Settings.noargs)

                api(DependenciesVersion.Kodein.core)

                api(DependenciesVersion.SqlDelight.core)
            }
        }

        androidMain {
            dependencies {
                implementation(DependenciesVersion.Ktor.android)
                implementation(DependenciesVersion.SqlDelight.android)
                implementation(DependenciesVersion.Android.Compose.ui)
            }
        }

        iosMain {
            dependencies {
                implementation(DependenciesVersion.Ktor.ios)
                implementation(DependenciesVersion.SqlDelight.ios)
            }
        }

        desktopMain {
            dependencies {
                implementation(DependenciesVersion.Ktor.okhttp)
                implementation(DependenciesVersion.SqlDelight.desktop)
            }
        }
    }
}

sqldelight {
    database("Database"){
        packageName = "com.observer.playzone"
        schemaOutputDirectory = file("src/commonMain/sqldelight/database/schema")
        migrationOutputDirectory = file("src/commonMain/sqldelight/database/migrations")

    }
}