package login

import LoginView
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import login.models.LoginAction
import navigation.NavigationTree
import ru.alexgladkov.odyssey.compose.extensions.present
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.alexgladkov.odyssey.core.LaunchFlag


@Composable
internal fun LoginScreen() {
    val rootController = LocalRootController.current
    StoredViewModel(factory = { LoginViewModel() }) { viewModel ->
        val state = viewModel.viewStates().observeAsState()
        val viewAction = viewModel.viewActions().observeAsState()
        LoginView(state = state.value) {
            viewModel.obtainEvent(it)
        }


        var currentAction = viewAction.value

        LaunchedEffect(viewAction.value) {
            when (currentAction) {
                is LoginAction.OpenMainFlow ->{
                    rootController.findRootController()
                        .present(
                            screen = NavigationTree.Main.Dashboard.name,
                            launchFlag = LaunchFlag.SingleNewTask
                        )

                    viewModel.clearAction()
                }

                is LoginAction.OpenRegistrationScreen ->{
                    rootController.push(
                        NavigationTree.Auth.RegisterScreen.name
                    )
                    viewModel.clearAction()

                }

                is LoginAction.OpenForgotPasswordScreen ->{
                    rootController.push(
                        screen = NavigationTree.Auth.ForgotScreen.name
                    )
                    viewModel.clearAction()

                }

                null -> {}
            }
        }

    }
}


