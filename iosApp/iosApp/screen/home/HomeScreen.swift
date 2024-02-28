
import SwiftUI
import SharedSDK


struct HomeScreen: View{
    private val viewModel = HomeViewModel()
    var body : some View{
       ObservingView(statePublisher: viewModel.statePublisher) { state in
            VStack{
                Text("Hello, World!")
                Button(action: {
                    viewModel.onButtonClicked()
                }){
                    Text("Click me")
                }
            }
        }
    }
}

struct HomeScreen_Previews: PreviewProvider {
    static var previews: some View {
        HomeScreen()
    }
}