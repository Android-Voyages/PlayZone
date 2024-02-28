package settings

import com.russhwolf.settings.Settings
import com.russhwolf.settings.get

class SettingsAuthDataSource(
    private val settings: Settings
) {

    fun saveToken(token: String) {
        settings.putString(token_key, token)
    }

    fun fetchToken(): String {
        return settings[token_key, ""]
    }

    companion object{
       private const val token_key = "token"
    }
}