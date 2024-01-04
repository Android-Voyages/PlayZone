enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "PlayZone"
//base
include(":androidApp")
include(":shared")
//auth
include(":common:auth:api")
include(":common:auth:presentation")
include(":common:auth:data")
//tournaments
include(":common:tournaments:api")
include(":common:tournaments:presentation")
include(":common:tournaments:data")
//games
include(":common:games:api")
include(":common:games:presentation")
include(":common:games:data")
//core
include(":common:core")
//Umbrella
include(":common:umbrella-ios")
include(":common:umbrella-compose")