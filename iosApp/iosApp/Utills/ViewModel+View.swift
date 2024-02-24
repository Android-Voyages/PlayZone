

import SwiftUI
import Combine


private class ObservableModel<StateObserved: ObservableObject{
    @Published var stateObserved: StateObserved?

    init(stateObserved: AnyPublisher<StateObserved?, Never>) {
       stateObserved
            .compactMap { $0 }
            .receive(on: DispatchQueue.main)
            .assign(to: &$stateObserved)
    }
}

public struct ObservingView<StateObserved,Content>: View where Content: View{
    @ObservedObject private var model: ObservableModel<StateObserved>

    private let content: (StateObserved) -> Content

    public init(statePublisher: AnyPublisher<StateObserved, Never>, @ViewBuilder content:  @escaping (StateObserved)
    -> Content){
        self.content = content
        self.model = ObservableModel(statePublisher: statePublisher)
    }

    public var body: some View{
        let view: AnyView
        if let viewState = self.model.stateObserved{
            view = AnyView(content(viewState))
        }else{
            view = AnyView(EmptyView())
        }
        return view
    }



}

