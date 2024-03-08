plugins {
    id("multiplatform-setup")
}
kotlin {

sourceSets {

        androidMain {
            dependencies {
                implementation(libs.compose.ui)
            }
        }
    }
}
android{
    namespace = "com.observer.playzone"
}