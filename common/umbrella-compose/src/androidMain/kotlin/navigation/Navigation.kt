package navigation

import androidx.compose.material.Text
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import login.SplashScreen
import mainFlow


fun RootComposeBuilder.generateGraph() {

    screen(name = NavigationTree.Splash.SplashScreen.name) {
        SplashScreen()
    }

    screen(name = NavigationTree.Main.Game.name){
        Text("Hello Game Detail")
    }
    authFlow()
    mainFlow()
}