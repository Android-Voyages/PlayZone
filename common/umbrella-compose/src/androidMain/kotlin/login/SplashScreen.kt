package login

import androidx.compose.runtime.Composable
import navigation.NavigationTree
import ru.alexgladkov.odyssey.compose.extensions.present
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.alexgladkov.odyssey.core.LaunchFlag


@Composable
fun SplashScreen() {
    val rootController = LocalRootController.current

    rootController.present(
       screen =  NavigationTree.Auth.AuthScreen.name,
        launchFlag  = LaunchFlag.SingleNewTask
    )
}