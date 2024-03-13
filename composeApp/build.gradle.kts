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
			export(projects.common.core)
			export(projects.common.coreUtils)
			export(projects.common.auth.api)
			export(projects.common.auth.presentation)
			export(projects.common.games.presentation)
			export(projects.common.games.api)
			export(projects.common.main.api)
			export(projects.common.main.presentation)
		}
	}
	androidTarget()
	jvmToolchain(17)
	jvm()
	js{
		moduleName = "composeApp"
		browser{
			commonWebpackConfig{
				outputFileName = "composeApp.js"
			}
		}
		binaries.executable()
	}
	listOf(
		iosX64(),
		iosArm64(),
		iosSimulatorArm64()
	).forEach{
		it.binaries.framework{
			baseName = "ComposeApp"
			isStatic = false
			linkerOpts.add("-lsqlite3")
		}
	}
	targets.withType<KotlinNativeTarget>{
		binaries.all{
			linkerOpts.add("-lsqlite3")
		}
	}
	sourceSets {
		commonMain.dependencies {
			implementation(projects.common.core)
			implementation(projects.common.coreCompose)
			implementation(projects.common.coreUtils)
			implementation(projects.common.auth.data)
			implementation(projects.common.auth.compose)
			implementation(projects.common.games.api)
			implementation(projects.common.games.data)
			implementation(projects.common.tournaments.data)
			implementation(projects.common.main.compose)
			implementation(compose.runtime)
			implementation(compose.ui)
			implementation(compose.foundation)
			implementation(compose.material)

			implementation(libs.odyssey.compose)
			implementation(libs.odyssey.core)
			implementation(libs.kviewmodel.core)
			implementation(libs.kviewmodel.compose)
			implementation(libs.kviewmodel.odyssey)

		}

		jvmMain.dependencies {
			implementation(compose.desktop.currentOs)
		}
		jsMain.dependencies {
			implementation(compose.html.core)
			implementation(libs.sqldelight.js.driver)
			implementation(npm("sql.js", "1.6.2"))
			implementation(devNpm("copy-webpack-plugin", "9.1.0"))
			implementation(npm("@cashapp/sqldelight-sqljs-worker", "2.0.1"))

		}
		androidMain.dependencies {
			implementation(libs.androidx.activity.compose)
			implementation(libs.androidx.appcompat)
			implementation(libs.compose.material)
		}
		iosMain{
			dependencies{
				api(projects.common.core)
				api(projects.common.coreUtils)
				api(projects.common.auth.api)
				api(projects.common.auth.presentation)
				api(projects.common.main.api)
				api(projects.common.main.presentation)
				api(projects.common.games.api)
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
compose.experimental{
	web.application {

	}
}