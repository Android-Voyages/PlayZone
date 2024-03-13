import org.gradle.internal.impldep.junit.runner.Version.id

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.4.0"
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")

    }
}

rootProject.name = "PlayZone"
//ui
include(":composeApp")

//auth
include(":common:auth:api")
include(":common:auth:presentation")
include(":common:auth:data")
include(":common:auth:compose")

//tournaments
include(":common:tournaments:api")
include(":common:tournaments:presentation")
include(":common:tournaments:data")
include(":common:tournaments:compose")

//Main
include(":common:main:api")
include(":common:main:presentation")
include(":common:main:data")
include(":common:main:compose")

//games
include(":common:games:api")
include(":common:games:presentation")
include(":common:games:data")
include(":common:games:compose")

//core
include(":common:core")
include(":common:core-compose")
include(":common:core-utils")

//Umbrella
include(":common:umbrella-compose")
