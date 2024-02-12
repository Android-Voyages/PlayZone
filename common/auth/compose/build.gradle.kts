plugins{
    id("multiplatform-compose-setup")
    id("android-setup")
}


kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(project(":common:auth:presentation"))
            implementation(project(":common:core-compose"))
            implementation(project(":common:core-utils"))
            implementation(DependenciesVersion.Other.ViewModel.core)
            implementation(DependenciesVersion.Other.ViewModel.compose)
            implementation(DependenciesVersion.Other.ViewModel.odyssey)
            implementation(DependenciesVersion.Other.Navigation.core)
            implementation(DependenciesVersion.Other.Navigation.compose)
        }

        androidMain.dependencies {
            implementation(DependenciesVersion.Android.Compose.ui)
            implementation(DependenciesVersion.Android.Compose.material)
            implementation(DependenciesVersion.Android.Compose.icons)
            implementation(DependenciesVersion.Android.Compose.tooling)

        }
    }
}
