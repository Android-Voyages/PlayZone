plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    mavenLocal()
    google()
    maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    implementation(DependenciesVersion.Kotlin.gradlePlugin)
    implementation(DependenciesVersion.Compose.gradlePlugin)
    implementation(DependenciesVersion.Android.gradlePlugin)
    implementation(DependenciesVersion.Kotlin.Serialization.gradlePlugin)
    implementation(DependenciesVersion.SqlDelight.gradlePlugin)
}

kotlin {
    sourceSets.getByName("main").kotlin.srcDir("buildSrc/src/main/kotlin")
}