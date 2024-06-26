import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import theme.Theme


@Composable
fun ActionButton(
	hint: String,
	enabled: Boolean = true,
	onValueChanged: () -> Unit,
){
	Button(
		modifier = Modifier
			.fillMaxWidth()
			.height(56.dp),
		colors = ButtonDefaults.buttonColors(
			backgroundColor = Theme.colors.primaryAction
		),
		enabled =enabled,
		shape = RoundedCornerShape(10.dp),
		onClick = onValueChanged) {
		Text(
			text = hint,
			color = Theme.colors.primaryTextColor,
			fontSize = 16.sp,
			fontWeight = FontWeight.Bold
		)
	}
}