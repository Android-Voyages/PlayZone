import admin.creategame.model.AdminCreateGameAction
import admin.creategame.model.AdminCreateGameEvent
import admin.creategame.model.AdminCreateGameViewState
import com.adeo.kviewmodel.BaseSharedViewModel
import kotlinx.coroutines.launch


class AdminCreateGameViewModel :
	BaseSharedViewModel<AdminCreateGameViewState, AdminCreateGameAction, AdminCreateGameEvent>(
		initialState = AdminCreateGameViewState()
	) {

		private val authRepository: AuthRepository = Inject.instance()
		private val gamesRepository: GamesRepository = Inject.instance()
	override fun obtainEvent(viewEvent : AdminCreateGameEvent) {
		when (viewEvent) {
			is AdminCreateGameEvent.TitleChanged -> viewState =
				viewState.copy(title = viewEvent.value)

			is AdminCreateGameEvent.DescriptionChanged -> viewState =
				viewState.copy(description = viewEvent.value)

			is AdminCreateGameEvent.VersionChanged -> viewState =
				viewState.copy(version = viewEvent.value)

			is AdminCreateGameEvent.SizeChanged -> viewState =
				viewState.copy(size = viewEvent.value)

			is AdminCreateGameEvent.SubmitChanges ->  createGame()
		}
	}

	private fun createGame() {
		viewModelScope.launch {
			viewState = viewState.copy(isSending = true)
			try {
				val token = authRepository.fetchToken()
				gamesRepository.createGame(
					token = token,
					info = CreateGameInfo(
						title = viewState.title,
						description = viewState.description,
						version = viewState.version,
						size = viewState.size.toDouble()
					)
				)
				viewAction = AdminCreateGameAction.CloseScreen
			}catch (_ : Exception){
				viewState = viewState.copy(isSending = false)
			}
		}
	}

}