import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.observer.playzone.AuthRes
import login.models.LoginEvent
import login.models.LoginViewState
import theme.Theme


@Composable
fun LoginView(state: LoginViewState, eventHandler: (LoginEvent) -> Unit) {
    Column(
	    modifier = Modifier.padding(30.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
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
        Spacer(modifier = Modifier.height(50.dp))


	    CommonTextField(text = state.email, hint = "Your Login", enabled = ! state.isSending) {
		    eventHandler.invoke(LoginEvent.EmailChanged(it))
	    }
        Spacer(modifier = Modifier.height(24.dp))

	    CommonTextField(
		    text = state.password,
		    hint = "Your Password",
		    enabled = ! state.isSending,
		    isSecure = state.passwordHidden,
            trailingIcon = {
                Icon(
                    modifier = Modifier.clickable {
                        eventHandler.invoke(LoginEvent.PasswordShowClicked)
                    },
                    imageVector = if (state.passwordHidden) Icons.Outlined.Clear else Icons.Outlined.Lock,
                    contentDescription = "Password hidden",
                    tint = Theme.colors.hintTextColor
                )
            }
	    ) {
		    eventHandler.invoke(LoginEvent.PasswordChanged(it))
	    }

        Spacer(modifier = Modifier.height(30.dp))

	    Row(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                modifier = Modifier.clickable { eventHandler.invoke(LoginEvent.ForgotClicked) },
                text = AuthRes.string.auth_forgot_password,
                color = Theme.colors.primaryAction,
                fontSize = 12.sp,
            )
        }

        Spacer(modifier = Modifier.height(30.dp))
		ActionButton(
			hint = "Login now",
			enabled = !state.isSending
		){
			eventHandler.invoke(LoginEvent.LoginClicked)
		}
    }
}