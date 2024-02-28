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
include(":common:umbrella-ios")
include(":common:umbrella-compose")
