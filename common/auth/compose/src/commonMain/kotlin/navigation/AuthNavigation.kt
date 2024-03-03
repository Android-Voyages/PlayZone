package navigation

import forgot.ForgotScreen
import login.LoginScreen
import register.RegisterScreen
import ru.alexgladkov.odyssey.compose.extensions.flow
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder


fun RootComposeBuilder.authFlow(){
    flow(name = NavigationTree.Auth.AuthScreen.name){
        screen(name = NavigationTree.Auth.LoginScreen.name){
            LoginScreen()
        }

        screen(name = NavigationTree.Auth.ForgotScreen.name){
            ForgotScreen()
        }

        screen(name = NavigationTree.Auth.RegisterScreen.name){
            RegisterScreen()
        }
    }
}