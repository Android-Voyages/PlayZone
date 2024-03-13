plugins {
    id("multiplatform-setup")
    id(libs.plugins.serialization.get().pluginId)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(projects.common.games.api)
                implementation(projects.common.core)
            }
            androidMain {
                dependencies {
                    implementation(libs.compose.ui)
                }
            }
        }
    }
}
android{
    namespace = "com.observer.playzone"
}