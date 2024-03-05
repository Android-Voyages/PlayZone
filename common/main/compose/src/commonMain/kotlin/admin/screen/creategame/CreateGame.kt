import admin.creategame.model.AdminCreateGameAction
import admin.creategame.model.AdminCreateGameEvent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import ru.alexgladkov.odyssey.compose.local.LocalRootController


@Composable
fun CreateGameScreen(){
	val rootController = LocalRootController.current
	StoredViewModel({AdminCreateGameViewModel()}){viewModel->
		val viewState = viewModel.viewStates().observeAsState().value
		val viewAction = viewModel.viewActions().observeAsState().value

		Column(modifier = Modifier.padding(16.dp)) {
			CommonTextField(
				text = viewState.title,
				hint = "Game Title",
				enabled = !viewState.isSending,
			){
				viewModel.obtainEvent(AdminCreateGameEvent.TitleChanged(it))
			}
			Spacer(modifier = Modifier.height(16.dp))
			CommonTextField(
				text = viewState.description,
				hint = "Game Description",
				enabled = !viewState.isSending,
			){
				viewModel.obtainEvent(AdminCreateGameEvent.DescriptionChanged(it))
			}
			Spacer(modifier = Modifier.height(16.dp))
			CommonTextField(
				text = viewState.version,
				hint = "Game Version",
				enabled = !viewState.isSending,
			){
				viewModel.obtainEvent(AdminCreateGameEvent.VersionChanged(it))
			}
			Spacer(modifier = Modifier.height(16.dp))
			CommonTextField(
				text = viewState.size,
				hint = "Game Size",
				enabled = !viewState.isSending,
			){
				viewModel.obtainEvent(AdminCreateGameEvent.SizeChanged(it))
			}
			Spacer(modifier = Modifier.height(16.dp))

			ActionButton(
				hint = "Save Changes",
				enabled = !viewState.isSending
			){
				viewModel.obtainEvent(AdminCreateGameEvent.SubmitChanges)
			}
		}
		when(viewAction){
			is AdminCreateGameAction.CloseScreen ->{
				rootController.popBackStack()
			}

			null -> {

			}
		}
	}
}