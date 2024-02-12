package navigation

import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import splash.SplashScreen


fun RootComposeBuilder.generateGraph() {

    screen(name = NavigationTree.Splash.SplashScreen.name) {
        SplashScreen()
    }

    authFlow()
}