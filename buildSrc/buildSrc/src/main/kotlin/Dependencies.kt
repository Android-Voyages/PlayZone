object Dependencies {

    object Kodein{
        const val core = "org.kodein.di:kodein-di:7.21.1"
    }
    object Kotlin{
        private const val version ="1.9.21"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"

        object Serialization{
            const val gradlePlugin = "org.jetbrains.kotlin:kotlin-serialization:1.9.21"
            const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-core:1.6.2"
        }

        object Coroutines{
            private const val version = "1.7.3"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        }
    }

    object Ktor{
        private const val version = "2.3.7"
        const val core = "io.ktor:ktor-client-core:$version"
        const val json = "io.ktor:ktor-client-json:$version"
        const val ios = "io.ktor:ktor-client-ios:$version"
        const val serialization = "io.ktor:ktor-client-serialization:$version"
        const val logging = "io.ktor:ktor-client-logging:$version"
        const val android = "io.ktor:ktor-client-android:$version"
        const val okhttp = "io.ktor:ktor-client-okhttp:$version"
    }
    object Compose{
        private const val version ="1.5.11"
        const val gradlePlugin = "org.jetbrains.compose:compose-gradle-plugin:$version"
    }

    object SqlDelight{
        private const val version = "1.5.5"

        const val gradlePlugin = "com.squareup.sqldelight:gradle-plugin:$version"
        const val core = "com.squareup.sqldelight:runtime:$version"
        const val android = "com.squareup.sqldelight:android-driver:$version"
        const val dekstop = "com.squareup.sqldelight:sqlite-driver:$version"
        const val ios = "com.squareup.sqldelight:native-driver:$version"
    }

    object Android{
        const val gradlePlugin = "com.android.tools.build:gradle:8.1.2"
    }
}