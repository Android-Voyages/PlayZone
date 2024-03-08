plugins{
    id("multiplatform-setup")
    id(libs.plugins.serialization.get().pluginId)
}
kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:core"))
                implementation(libs.kotlinx.serialization.core)
            }
        }
        androidMain {
            dependencies {
                implementation(libs.compose.ui)
            }
        }
    }
}

android{
    namespace = "com.observer.playzone"
}