import com.adeo.kviewmodel.BaseSharedViewModel
import kotlinx.coroutines.launch


class AdminGamesViewModel: BaseSharedViewModel<AdminGamesViewState,AdminGamesAction,AdminGamesEvent>(
	initialState = AdminGamesViewState()
){

	init {
		fetchAllGames()
	}

	private val gamesRepository: GamesRepository = Inject.instance()
	override fun obtainEvent(viewEvent : AdminGamesEvent) {
		when(viewEvent){
			AdminGamesEvent.AddGameClicked ->{
				viewAction = AdminGamesAction.ShowAddGame
			}

			else -> {}
		}
	}

	private fun fetchAllGames() {
		viewModelScope.launch {
			val games = gamesRepository.fetchAllGames()
			viewState = viewState.copy(games = games)
		}
	}

}