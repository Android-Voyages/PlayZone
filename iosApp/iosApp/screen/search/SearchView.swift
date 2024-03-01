import SwiftUI
import SharedSDK



struct SearchView: View{
    let viewState: SearchViewState
    let eventHandler: (SearchEvent) -> void


    var body: some View{
        ZStack{
            VStack{
                Spacer().frame(height: 26)
                CommonTextField(hint: "Search Game"){newValue in
                    eventHandler(SearchEvent.QueryChanged(newValue))

                }
                Spacer().frame(height: 16)

                ScrollView{
                    VStack{
                        Foreach(viewState.games,id: \.gameId){game in
                            VStack(alignment: .leading){
                                   Text(game.title)
                                        .foregroundColor(.textPrimary)
                                        .padding(EdgeInsets(top: 8,leading: 16,bottom:8,trailing:16))
                            }
                        }
                    }
                }
            }
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
        .background(Color.backgroundPrimary)
    }
}