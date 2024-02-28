package login

import AuthRepository
import GamesRepository
import Inject
import com.adeo.kviewmodel.BaseSharedViewModel
import kotlinx.coroutines.launch
import login.models.LoginAction
import login.models.LoginEvent
import login.models.LoginViewState

class LoginViewModel : BaseSharedViewModel<LoginViewState, LoginAction, LoginEvent>(
    initialState = LoginViewState(
        email = "",
        password = ""
    )
) {

    private val authRepository: AuthRepository = Inject.instance()
    override fun obtainEvent(viewEvent: LoginEvent) {
        when (viewEvent) {
            is LoginEvent.LoginClicked -> sendLogin()

            is LoginEvent.EmailChanged -> obtainEmailChanged(viewEvent.email)

            is LoginEvent.PasswordChanged -> obtainPasswordChanged(viewEvent.password)

            is LoginEvent.ForgotClicked -> openForgot()

            is LoginEvent.RegistrationClicked -> openRestration()

            is LoginEvent.PasswordShowClicked -> changePasswordVisibility()
        }
    }

    private fun changePasswordVisibility() {
        viewState = viewState.copy(passwordHidden = !viewState.passwordHidden)
    }

    private fun obtainPasswordChanged(value: String) {
        viewState = viewState.copy(password = value)
    }

    private fun obtainEmailChanged(value: String) {
        viewState = viewState.copy(email = value)
    }

    private fun sendLogin() {
        viewState = viewState.copy(isSending = true)
        viewModelScope.launch {
            try {
                val response = authRepository.login(viewState.email, viewState.password)
                if (response.token.isNotBlank()) {
                    viewState = viewState.copy(email = "", password = "", isSending = false)
                    viewAction = LoginAction.OpenMainFlow
                } else {
                    viewState = viewState.copy(isSending = false)
                }
            } catch (e: Exception) {
                viewState.copy(isSending = false)
            }
        }
    }

    private fun openRestration() {
        viewAction = LoginAction.OpenRegistrationScreen
    }

    private fun openForgot() {
        viewAction = LoginAction.OpenForgotPasswordScreen

    }
}