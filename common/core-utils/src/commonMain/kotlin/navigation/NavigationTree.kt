package navigation

object NavigationTree {

    enum class Splash{
        SplashScreen
    }

    enum class Auth{
        AuthScreen, LoginScreen,RegisterScreen,ForgotScreen
    }

    enum class Main{
        Dashboard,Home,Search,Event,Videos,Profile,Game
    }
}