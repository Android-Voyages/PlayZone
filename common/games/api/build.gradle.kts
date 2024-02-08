plugins{
    id("multiplatform-setup")
    id("android-setup")
}
kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:core"))
            }
        }
        androidMain {
            dependencies {

                implementation(DependenciesVersion.Android.Compose.ui)
            }
        }
    }
}