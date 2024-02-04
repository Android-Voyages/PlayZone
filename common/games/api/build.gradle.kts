plugins{
    id("multiplatform-setup")
    id("android-setup")
}
kotlin {
    sourceSets {
        androidMain {
            dependencies {

                implementation(Dependencies.Android.Compose.ui)
            }
        }
    }
}