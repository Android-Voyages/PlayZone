plugins {
    id("multiplatform-setup")
    id(libs.plugins.serialization.get().pluginId)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(project(":common:games:api"))
                implementation(project(":common:core"))
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