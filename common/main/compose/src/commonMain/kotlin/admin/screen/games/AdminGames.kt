import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import navigation.NavigationTree
import ru.alexgladkov.odyssey.compose.extensions.present
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import search.models.SearchEvent
import theme.Theme


@Composable
fun AdminGames(){
	val rootController = LocalRootController.current
	StoredViewModel({AdminGamesViewModel()}){viewModel->
		val viewState = viewModel.viewStates().value
		val viewAction = viewModel.viewActions().observeAsState().value

		Column {
			Row(modifier = Modifier.padding(16.dp)) {
				Text(
					text = "Games List",
					fontSize = 28.sp,
					color = Theme.colors.secondaryTextColor,
				)
				Spacer(modifier = Modifier.weight(1f))

				Icon(
					imageVector = Icons.Filled.Add,
					contentDescription = "Add Game",
					tint = Theme.colors.primaryAction,
					modifier = Modifier
						.clickable {
							viewModel.obtainEvent(AdminGamesEvent.AddGameClicked)
						}
				)
			}

			LazyColumn {
				viewState.games.forEach {
					item {
						Column {
							Text(
								modifier = Modifier
									.padding(
										start = 16.dp,
										end = 16.dp,
										top = 8.dp,
										bottom = 8.dp
									),
								text = it.title,
								color = Theme.colors.secondaryTextColor,
								fontWeight = FontWeight.Medium
							)
						}
					}
				}
			}
		}

		when(viewAction){
			is AdminGamesAction.ShowAddGame -> {
				rootController.findRootController()
					.present(screen = NavigationTree.DesktopAdmin.CreateGame.name)
			}

			else -> {}
		}

		LaunchedEffect(Unit){
			viewModel.obtainEvent(AdminGamesEvent.ViewInited)
		}
	}
}