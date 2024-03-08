plugins{
    id("multiplatform-setup")
//    kotlin("plugin.serialization")
}

kotlin{
    sourceSets{
        commonMain.dependencies {
            implementation(project(":common:auth:api"))
            implementation(project(":common:core"))
            implementation(libs.multiplatform.settings.core)
        }
        androidMain.dependencies {
            implementation(libs.compose.ui)
        }
    }
}