import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.js.translate.context.Namer.kotlin

plugins {
	id(libs.plugins.android.get().pluginId)
	id(libs.plugins.kotlin.get().pluginId)
	id(libs.plugins.compose.get().pluginId)

}

kotlin {
	androidTarget()
	jvmToolchain(17)
	jvm()
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