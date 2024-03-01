import SwiftUI
import SharedSDK

struct HomeView: View{
    let viewState: HomeViewState
    let eventHandler: (HomeEvent) -> Void
    var body: some View{
        ZStack{
            VStack{
                Spacer().frame(height: 16)

                HStack{
                  Spacer().frame(width: 16)

                  AsyncImage(url: URL(string: viewState.avatarUrl)) { image in
                      image
                          .resizable()
                          .aspectRatio(contentMode: .fill)
                          .frame(width: 56, height: 56)
                  }, placeholder: {
                     ProgressView()
                  }).clipShape(Circle()).frame(width: 56, height: 56)

                    Spacer().frame(width: 20)

                    VStack(alignment: .leading){
                        Text(viewState.status).font(.system(size: 12).foregroundColor(.textPrimary.opacity(0.5)).fontWeight(.bold)
                        Spacer().frame(height: 4)
                        Text(viewState.username).font(.subheading).foregroundColor(.textSecondary)
                    }
                    Spacer()
                }
                .onTapGesture {
                    eventHandler(HomeEvent.UserProfileClicked())
                }

                Spacer()
            }
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
        .background(.backgroundPrimary)
    }
}

