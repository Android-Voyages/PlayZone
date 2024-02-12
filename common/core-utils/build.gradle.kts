plugins {
    id("multiplatform-setup")
    id("android-setup")
}
kotlin {
    sourceSets {

        androidMain {
            dependencies {
                implementation(DependenciesVersion.Android.Compose.ui)

            }
        }
    }
}