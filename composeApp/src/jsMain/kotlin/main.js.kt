import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import navigation.NavigationSource
import org.jetbrains.skiko.wasm.onWasmReady
import ru.alexgladkov.odyssey.compose.setup.OdysseyConfiguration
import ru.alexgladkov.odyssey.compose.setup.setNavigationContent
import theme.AppTheme
import theme.Theme
import navigation.generateGraph


@OptIn(ExperimentalComposeUiApi::class)
fun main(){
	onWasmReady {
		CanvasBasedWindow {
			PlatformSDK.init(
				configuration = PlatformConfiguration()
			)
			AppTheme {
				val configration = OdysseyConfiguration(
					backgroundColor = Theme.colors.primaryBackground
				)

				setNavigationContent(configration, onApplicationFinish = {

				}) {
					generateGraph(NavigationSource.Android)
				}
			}
		}
	}
}