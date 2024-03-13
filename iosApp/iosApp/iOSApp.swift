import SwiftUI
import SharedSDK

@main
struct iOSApp: App {
	init(){
	    PlatformSdk().doInit(configuration: PlatformConfiguration())
	}

	var body : some Scene {
        WindowGroup {
           // ContentView()
           ZStack{
           Color.init(hex: 0xFF050B18)
                .ignoresSafeArea()
               MainComposeView()
           }
        }
    }
}