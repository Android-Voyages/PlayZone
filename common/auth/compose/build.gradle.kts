plugins{
    id("multiplatform-setup")
    id(libs.plugins.libres.get().pluginId)
}
libres {
    generatedClassName = "AuthRes"
    generateNamedArguments = true
    baseLocaleLanguageCode = "en"
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.common.auth.presentation)
            implementation(projects.common.coreCompose)
            implementation(projects.common.coreUtils)
            implementation(libs.kviewmodel.core)
            implementation(libs.kviewmodel.compose)
            implementation(libs.kviewmodel.odyssey)
            implementation(libs.odyssey.core)
            implementation(libs.odyssey.compose)
            implementation(libs.libres.compose)
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