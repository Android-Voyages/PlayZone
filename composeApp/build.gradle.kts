import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
	id(libs.plugins.android.get().pluginId)
	id(libs.plugins.kotlin.get().pluginId)
	id(libs.plugins.compose.get().pluginId)
	id(libs.plugins.cocoapods.get().pluginId)
}

version = "0.0.1"


kotlin {
	cocoapods{
		summary = "PlayZone IOS SDK"
		homepage = "https://github.com/Android-Voyages/PlayZone"
		ios.deploymentTarget = "14.0"

		framework {
			transitiveExport = false
			baseName = "SharedSDK"
			export(project(":common:core"))
			export(project(":common:core-utils"))
			export(project(":common:auth:api"))
			export(project(":common:auth:presentation"))
			export(project(":common:games:presentation"))
			export(project(":common:games:api"))
			export(project(":common:main:api"))
			export(project(":common:main:presentation"))
		}
	}
	androidTarget()
	jvmToolchain(17)
	jvm()
	listOf(
		iosX64(),
		iosArm64(),
		iosSimulatorArm64()
	).forEach{
		it.binaries.framework{
			baseName = "SharedSDK"
			isStatic = false
		}
	}
	targets.withType<KotlinNativeTarget>{
		binaries.all{
			linkerOpts.add("-lsqlite3")
		}
	}
	sourceSets {
		commonMain.dependencies {
			implementation(project(":common:core"))
			implementation(project(":common:core-compose"))
			implementation(project(":common:games:api"))
			implementation(project(":common:games:data"))
			implementation(project(":common:umbrella-compose"))
			implementation(compose.runtime)
			implementation(compose.ui)
			implementation(compose.foundation)

			implementation(libs.odyssey.compose)
			implementation(libs.odyssey.core)
		}

		jvmMain.dependencies {
			implementation(compose.desktop.currentOs)
		}
		androidMain.dependencies {
			implementation(libs.androidx.activity.compose)
			implementation(libs.androidx.appcompat)
			implementation(libs.compose.material)
		}
		iosMain{
			dependencies{
				api(project(":common:core"))
				api(project(":common:core-utils"))
				api(project(":common:auth:api"))
				api(project(":common:auth:presentation"))
				api(project(":common:main:api"))
				api(project(":common:main:presentation"))
				api(project(":common:games:api"))
			}
		}
	}
}

android {
	namespace = "com.observer.playzone"
	compileSdk = libs.versions.maxSdk.get().toInt()
	defaultConfig {
		applicationId = "com.observer.playzone"
		minSdk = libs.versions.minSdk.get().toInt()
		targetSdk = libs.versions.maxSdk.get().toInt()
		versionCode = 1
		versionName = "1.0"
	}

	buildFeatures {
		compose = true
	}

	composeOptions {
		kotlinCompilerExtensionVersion = libs.versions.plugin.compose.compiler.get()
	}

	buildTypes {
		getByName("release") {
			isMinifyEnabled = false
		}
	}
}
compose.desktop {
	application {
		mainClass = "Main_desktopKt"

		nativeDistributions{
			targetFormats(TargetFormat.Dmg,TargetFormat.Exe,TargetFormat.Deb)
			packageName = "com.observer.playzone"
			packageVersion = "1.0.0"
		}
	}
}