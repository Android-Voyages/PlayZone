import navigation.NavigationTree
import ru.alexgladkov.odyssey.compose.extensions.bottomNavigation
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.extensions.tab
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder


fun RootComposeBuilder.adminFlow(){
	bottomNavigation(
		name = NavigationTree.DesktopAdmin.Dashboard.name,
		tabsNavModel = BottomConfiguration()
	){
		tab(HomeTab()){
			screen(name = NavigationTree.DesktopAdmin.Games.name){
				AdminGames()
			}
		}
		tab(EventsTab()){
			screen(name = NavigationTree.DesktopAdmin.Events.name){
				AdminEvents()
			}
		}


	}
}