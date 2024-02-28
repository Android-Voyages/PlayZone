plugins{
    id("multiplatform-compose-setup")
    id("android-setup")
    kotlin("plugin.serialization")
}

kotlin{
    sourceSets{
        commonMain.dependencies {
            api(DependenciesVersion.Kotlin.Serialization.serialization)

        }
    }
}