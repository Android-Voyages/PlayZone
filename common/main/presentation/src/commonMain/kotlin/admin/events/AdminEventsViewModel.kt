import admin.creategame.model.AdminCreateGameAction
import admin.creategame.model.AdminCreateGameEvent
import admin.creategame.model.AdminCreateGameViewState
import com.adeo.kviewmodel.BaseSharedViewModel


class AdminEventsViewModel : BaseSharedViewModel<AdminCreateGameViewState, AdminCreateGameAction, AdminCreateGameEvent>(
	initialState = AdminCreateGameViewState()
){
	override fun obtainEvent(viewEvent : AdminCreateGameEvent) {
		return
	}

}