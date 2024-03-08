import org.jetbrains.kotlin.js.translate.context.Namer.kotlin

plugins {
	id(libs.plugins.android.get().pluginId)
	id(libs.plugins.kotlin.get().pluginId)
	id(libs.plugins.compose.get().pluginId)

}

kotlin {
	androidTarget()
	jvmToolchain(17)
	sourceSets {
		commonMain.dependencies {
			implementation(project(":common:core"))
			implementation(project(":common:games:api"))
			implementation(project(":common:games:data"))
			implementation(project(":common:umbrella-compose"))
			implementation(compose.runtime)
			implementation(compose.ui)
			implementation(compose.foundation)

			implementation(libs.odyssey.compose)
			implementation(libs.odyssey.core)
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