plugins{
    id("multiplatform-compose-setup")
    id("android-setup")
}


kotlin{
    sourceSets{
        commonMain.dependencies {
            api(project(":common:auth:api"))
            implementation(DependenciesVersion.Other.ViewModel.core)
        }
    }
}