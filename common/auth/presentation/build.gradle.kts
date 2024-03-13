plugins{
    id("multiplatform-setup")
}


kotlin{
    sourceSets{
        commonMain.dependencies {
            api(projects.common.core)
            api(projects.common.games.api)
            api(projects.common.auth.api)
            implementation(libs.kviewmodel.core)
        }
    }
}
android{
    namespace = "com.observer.playzone"
}