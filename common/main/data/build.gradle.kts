plugins{
    id("multiplatform-setup")
    id(libs.plugins.serialization.get().pluginId)
}

android{
    namespace = "com.observer.playzone"
}