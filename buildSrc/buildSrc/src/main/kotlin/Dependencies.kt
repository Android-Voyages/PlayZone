object Dependencies {
    object Kotlin{
        private const val version ="1.9.21"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    }

    object Compose{
        private const val version ="1.5.11"
        const val gradlePlugin = "org.jetbrains.compose:compose-gradle-plugin:$version"
    }

    object Android{
        const val gradlePlugin = "com.android.tools.build:gradle:8.1.2"
    }
}