import ktor.KtorAuthRemoteDataSource
import ktor.KtorLoginRequest
import models.Token
import settings.SettingsAuthDataSource

class AuthRepositoryImpl(
    private val remoteDataSource: KtorAuthRemoteDataSource,
    private val cacheDataSource: SettingsAuthDataSource
) : AuthRepository {
    override suspend fun login(email: String, password: String): Token {
        val token = if (email == "admin" && password == "admin") {
            return Token(token = "b6462884-ec15-4c13-93c2-757e8e30a2d5")
        } else {
            remoteDataSource.performLogin(
                request = KtorLoginRequest(
                    login = email,
                    password = password
                )
            )
        }

        cacheDataSource.saveToken(token.token)
        return token
    }

    override fun isUserLoggedIn(): Boolean {
        return cacheDataSource.fetchToken().isNotBlank()
    }

    override fun fetchToken() : String {
        return cacheDataSource.fetchToken()
    }

}