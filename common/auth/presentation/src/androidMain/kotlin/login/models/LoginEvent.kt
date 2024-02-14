package login.models

sealed class LoginEvent {
    data class EmailChanged(val email: String) : LoginEvent()
    data class PasswordChanged(val password: String) : LoginEvent()
    object LoginClicked : LoginEvent()
    object RegistrationClicked : LoginEvent()
    object ForgotClicked : LoginEvent()
}
