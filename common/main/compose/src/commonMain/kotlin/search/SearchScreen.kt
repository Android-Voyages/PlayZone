import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import navigation.NavigationTree
import ru.alexgladkov.odyssey.compose.extensions.present
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import search.SearchViewModel
import search.models.SearchAction


@Composable
fun SearchScreen(){
    val rootController = LocalRootController.current

    StoredViewModel(factory = { SearchViewModel() }) {viewModel->
        val viewState = viewModel.viewStates().observeAsState()
        val viewAction = viewModel.viewActions().observeAsState()

        SearchView(viewState.value){
            viewModel.obtainEvent(it)
        }

        when(viewAction.value){

            is SearchAction.ShowGameDetails ->{
                rootController.findRootController()
                    .present(
                        screen = NavigationTree.Main.Game.name,
                    )
                viewModel.clearAction()
            }
            null ->{}
        }
    }
}

