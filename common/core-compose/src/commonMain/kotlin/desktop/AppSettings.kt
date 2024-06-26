package desktop

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AppSettings {

	private val _windowState : MutableStateFlow<WindowState> =
		MutableStateFlow(WindowState.Custom(1024.dp, 800.dp))

	val windowState : StateFlow<WindowState> = _windowState

	fun updateWindowState(state : WindowState) {
		_windowState.value = state
	}
}

val LocalAppSettings = staticCompositionLocalOf<AppSettings> { error("No LocalAppSettings  implementation") }