import com.adeo.kviewmodel.BaseSharedViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class AdminGamesViewModel: BaseSharedViewModel<AdminGamesViewState,AdminGamesAction,AdminGamesEvent>(
	initialState = AdminGamesViewState()
){

	private val gamesRepository: GamesRepository = Inject.instance()
	private val authRepository: AuthRepository = Inject.instance()
	override fun obtainEvent(viewEvent : AdminGamesEvent) {
		when(viewEvent){
			AdminGamesEvent.ViewInited -> fetchAllGames()
			AdminGamesEvent.AddGameClicked ->{
				viewAction = AdminGamesAction.ShowAddGame
			}

			else -> {}
		}
	}

	private fun fetchAllGames() {
		viewModelScope.launch {
			viewState = try {
				val token = authRepository.fetchToken()
				val games = gamesRepository.fetchAllGames(token)
				viewState.copy(games = games)
			}catch (e: Exception){
				e.printStackTrace()
				viewState.copy(games = emptyList())
			}
		}
	}

}