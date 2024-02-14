package login
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import login.models.LoginEvent
import theme.Theme


@Composable
internal fun LoginScreen() {

    StoredViewModel(factory = { LoginViewModel()}) {viewModel->
        val state = viewModel.viewStates().observeAsState()
        Column(modifier = Modifier.padding(30.dp), horizontalAlignment = Alignment.CenterHorizontally){
            Text(
                text = "Login now",
                color = Theme.colors.thirdTextColor,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                modifier = Modifier.padding(top = 15.dp),
                text = "Welcome back to PlayZone! Enter your email addres and your password to enjoy the latest features of PlayZone\n",
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                color = Theme.colors.hintTextColor
            )
            TextField(value = state.value.email , onValueChange = {
                viewModel.obtainEvent(LoginEvent.EmailChanged(it))
            })
        }
    }
}