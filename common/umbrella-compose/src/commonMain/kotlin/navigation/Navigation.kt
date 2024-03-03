package navigation

import SplashScreen
import adminFlow
import androidx.compose.material.Text
import mainFlow
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder

enum class NavigationSource {
    Desktop, Android, Ios
}

fun RootComposeBuilder.generateGraph(source : NavigationSource) {

    screen(name = NavigationTree.Splash.SplashScreen.name) {
        SplashScreen()
    }

    screen(name = NavigationTree.Main.Game.name) {
        Text("Hello Game Detail")
    }
    authFlow()

    when (source) {
        NavigationSource.Android -> {
            mainFlow()
        }

        NavigationSource.Desktop -> {
            adminFlow()
        }

        NavigationSource.Ios -> {}
    }
}