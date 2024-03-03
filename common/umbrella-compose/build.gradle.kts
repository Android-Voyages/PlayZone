plugins {
    id("multiplatform-compose-setup")
    id("android-setup")
}
dependencies {
	implementation(project(":common:core"))
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:core"))
                implementation(project(":common:core-compose"))
                implementation(project(":common:core-utils"))
                implementation(project(":common:auth:data"))
                implementation(project(":common:auth:compose"))
                implementation(project(":common:games:data"))
                implementation(project(":common:tournaments:data"))
                implementation(project(":common:main:compose"))

                implementation(DependenciesVersion.Other.ViewModel.core)
                implementation(DependenciesVersion.Other.ViewModel.compose)
                implementation(DependenciesVersion.Other.ViewModel.odyssey)

                implementation(DependenciesVersion.Other.Navigation.compose)
                implementation(DependenciesVersion.Other.Navigation.core)
            }
        }

        androidMain {
            dependencies {
                implementation(project(":common:core-compose"))


                implementation(DependenciesVersion.Android.composeActivity)
                implementation(DependenciesVersion.Android.Compose.ui)

            }
        }
    }
}