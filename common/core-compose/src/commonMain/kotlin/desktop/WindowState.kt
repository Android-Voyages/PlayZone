package desktop

import androidx.compose.ui.unit.Dp

sealed class WindowState {
	object FullScreen : WindowState()
	object Maximized : WindowState()
	data class Custom(val width : Dp, val height : Dp) : WindowState()
}
