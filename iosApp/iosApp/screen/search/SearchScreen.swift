
import SwiftUI
import SharedSDK

struct SearchScreen: View{
    private let viewModel = SearchViewModel()
    var body : some View{
        ObservingView(statePublisher: statePublisher(viewModel.viewStates()),content:{viewState in
            SearchView(viewState: viewState){event in
                viewModel.obtainEvent(viewEvent: event)
            }
        })
    }
}

struct SearchScreen_Previews: PreviewProvider {
    static var previews: some View {
        SearchScreen()
    }
}