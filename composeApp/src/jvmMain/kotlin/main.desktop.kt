import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import navigation.NavigationSource
import navigation.generateGraph
import ru.alexgladkov.odyssey.compose.setup.OdysseyConfiguration
import ru.alexgladkov.odyssey.compose.setup.setNavigationContent
import theme.AppTheme
import theme.Theme
import javax.swing.JFrame

fun main() = application{
	PlatformSDK.init(configuration = PlatformConfiguration())

	Window(
		onCloseRequest = ::exitApplication,
		title = "PlayZone Desktop",
		state = rememberWindowState(
			width = 1024.dp,
			height = 800.dp,
			position = WindowPosition(Alignment.Center)
		)
	){
		AppTheme{
			val configuration = OdysseyConfiguration(
				backgroundColor = Theme.colors.primaryBackground,
			)

			setNavigationContent(configuration, onApplicationFinish = {
				exitApplication()
			}){
				generateGraph(NavigationSource.Desktop)
			}
		}
	}
}