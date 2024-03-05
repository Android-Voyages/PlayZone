import setup.setupThemedNavigation
import java.io.File
import javax.swing.JFrame
import javax.swing.SwingUtilities

fun main() = SwingUtilities.invokeLater {
	PlatformSDK.init(
		configuration = PlatformConfiguration()
	)
	JFrame().setupThemedNavigation()
}