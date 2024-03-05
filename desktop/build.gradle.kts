import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
	kotlin("multiplatform")
	id("org.jetbrains.compose")
}

kotlin {
	jvm {
		withJava()
	}

	sourceSets {
		jvmMain.dependencies {
			implementation(compose.desktop.currentOs)
			implementation(project(":common:umbrella-compose"))

		}
		commonMain {
			dependencies {
				implementation(project(":common:core"))
				implementation(project(":common:core-compose"))
				implementation(project(":common:core-utils"))
				implementation(project(":common:auth:compose"))
				implementation(project(":common:umbrella-ios"))
				implementation(project(":common:umbrella-compose"))
				implementation(project(":common:games:api"))
				implementation(project(":common:main:compose"))
				implementation(project(":common:main:presentation"))
				implementation(DependenciesVersion.Other.Navigation.core)
				implementation(DependenciesVersion.Other.Navigation.compose)

			}
		}
	}
}

compose.desktop {
	application {
		mainClass = "Main_desktopKt"

		nativeDistributions {
			targetFormats(
				TargetFormat.Dmg,
				TargetFormat.Msi,
				TargetFormat.Deb
			)

			packageName = "PlayZone-Admin"
			packageVersion = "1.0.0"

			windows {
				menuGroup = "PlayZone Admin"
				upgradeUuid = "b6462884-ec15-4c13-93c2-757e8e30a2d5"

			}
		}
	}
}