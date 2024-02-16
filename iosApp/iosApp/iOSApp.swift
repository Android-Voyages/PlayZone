import SwiftUI

@main
struct iOSApp: App {
	init(){
	    PlatformSdk().doInit(configuration: PlatformConfiguration())
	}

	var body : some Scene {
        WindowGroup {
            ContentView()
        }
    }
}