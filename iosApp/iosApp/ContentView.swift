import SwiftUI
import shared

struct ContentView: View {
	var body: some View{
        LoginScreen()
           .background(Color.backgroundPrimary)
           .background(ignoreSafeAreaEdges:[.top,.bottom,.leading,.trailing])
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}