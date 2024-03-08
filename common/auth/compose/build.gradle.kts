plugins{
    id("multiplatform-setup")
}


kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(project(":common:auth:presentation"))
            implementation(project(":common:core-compose"))
            implementation(project(":common:core-utils"))
            implementation(libs.kviewmodel.core)
            implementation(libs.kviewmodel.compose)
            implementation(libs.kviewmodel.odyssey)
            implementation(libs.odyssey.core)
            implementation(libs.odyssey.compose)
        }

        androidMain.dependencies {
            implementation(libs.compose.ui)
            implementation(libs.compose.material)
            implementation(libs.compose.icons)
            implementation(libs.compose.tooling)
        }
    }
}
android{
    namespace = "com.observer.playzone"
}