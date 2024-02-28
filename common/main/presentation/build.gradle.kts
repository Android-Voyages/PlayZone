plugins{
    id("multiplatform-compose-setup")
    id("android-setup")
}


kotlin{
    sourceSets{
        commonMain.dependencies {
            api(project(":common:auth:api"))
            api(project(":common:games:api"))
            api(project(":common:main:api"))
            api(project(":common:core"))
            implementation(DependenciesVersion.Other.ViewModel.core)
        }
    }
}