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
                    Label("Events", systemImage: "person.fill")
                }


            VideoScreen()
                .tabItem {
                    Label("Videos", systemImage: "person.fill")
                }
       }

    }
}

struct MainView_Previews: PreviewProvider {
    static var previews: some View {
        MainView()
    }
}