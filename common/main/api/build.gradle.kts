plugins{
    id("multiplatform-setup")
    id(libs.plugins.serialization.get().pluginId)
}

kotlin{
    sourceSets{
        commonMain.dependencies {
            api(libs.kotlinx.serialization.core)
        }
    }
}
android{
    namespace = "com.observer.playzone"
}