
import SwiftUI
import SharedSDK


struct HomeScreen: View{
    private val viewModel = HomeViewModel()
    @State private var isProfilePresented = false
    var body : some View{
       ObservingView(statePublisher: statePublisher(viewModel.viewStates())) { viewState in
            HomeView(viewState: viewState){event in
                viewModel.obtainEvent(event)
            }
        }
        .sheet(isPresented: $isProfilePresented, content: {
            Text("Profile")
        })
        .onReceive(viewModel.eventsPublisher(), perform: { event in
            switch event {
            case is HomeEvent.OpenProfile:
                isProfilePresented = true
            default:
                break
            }
        })
    }
}

struct HomeScreen_Previews: PreviewProvider {
    static var previews: some View {
        HomeScreen()
    }
}