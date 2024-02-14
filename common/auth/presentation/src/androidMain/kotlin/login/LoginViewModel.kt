package login

import com.adeo.kviewmodel.BaseSharedViewModel
import login.models.LoginAction
import login.models.LoginEvent
import login.models.LoginViewState

class LoginViewModel : BaseSharedViewModel<LoginViewState, LoginAction, LoginEvent>(
    initialState = LoginViewState(
        email = "",
        password = ""
    )
) {
    override fun obtainEvent(viewEvent: LoginEvent) {
        when (viewEvent) {
            is LoginEvent.LoginClicked -> sendLogin()

            is LoginEvent.EmailChanged -> obtainEmailChanged(viewEvent.email)

            is LoginEvent.PasswordChanged ->  obtainPasswordChanged(viewEvent.password)

            is LoginEvent.ForgotClicked -> openForgot()

            is LoginEvent.RegistrationClicked -> openRestration()
        }
    }
    private fun obtainPasswordChanged(value: String) {
        viewState = viewState.copy(password = value)
    }

    private fun obtainEmailChanged(value: String) {
        viewState = viewState.copy(email = value)
    }

    private fun sendLogin() {
        viewState = viewState.copy(isSending = true)
    }

    private fun openRestration() {
        viewAction = LoginAction.OpenRegistrationScreen
    }

    private fun openForgot() {
        viewAction = LoginAction.OpenForgotPasswordScreen

    }
}