plugins{
    id("multiplatform-setup")
    id(libs.plugins.serialization.get().pluginId)
}

kotlin{
    sourceSets{
        commonMain.dependencies {
            implementation(projects.common.auth.api)
            implementation(projects.common.core)
            implementation(libs.kodein.di)
            implementation(libs.multiplatform.settings.core)
        }
        androidMain.dependencies {
            implementation(libs.compose.ui)
        }
    }
}