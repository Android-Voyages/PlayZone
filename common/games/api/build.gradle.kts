plugins{
    id("multiplatform-setup")
    id("android-setup")
    kotlin("plugin.serialization")
}
kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:core"))
                implementation(DependenciesVersion.Kotlin.Serialization.serialization)
            }
        }
        androidMain {
            dependencies {

                implementation(DependenciesVersion.Android.Compose.ui)
            }
        }
    }
}