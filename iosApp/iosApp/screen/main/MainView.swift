import SwiftUI


struct MainView: View{

    var body : some View{
       TabView{
            HomeScreen()
                .tabItem {
                    Label("Home", systemImage: "house")

                }


            SearchScreen()
                .tabItem {
                    Label("Search", systemImage: "magnifying-glass")
                }



            EventsScreen()
                .tabItem {
                    Label("Events", systemImage: "calendar")
                }


            VideoScreen()
                .tabItem {
                    Label("Videos", systemImage: "play.rectangle")
                }
       }

    }
}

struct MainView_Previews: PreviewProvider {
    static var previews: some View {
        MainView()
    }
}