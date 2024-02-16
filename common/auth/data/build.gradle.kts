plugins{
    id("multiplatform-setup")
    id("android-setup")
    kotlin("plugin.serialization")
}

kotlin{
    sourceSets{
        commonMain.dependencies {
            implementation(project(":common:auth:api"))
            implementation(project(":common:core"))
        }
        androidMain.dependencies {
            implementation(DependenciesVersion.Android.Compose.ui)

        }
    }
}