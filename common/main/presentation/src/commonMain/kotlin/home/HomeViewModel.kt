package home

import com.adeo.kviewmodel.BaseSharedViewModel
import home.models.HomeAction
import home.models.HomeEvent
import home.models.HomeViewState

class HomeViewModel: BaseSharedViewModel<HomeViewState,HomeAction,HomeEvent>(
    initialState = HomeViewState(
        "Erlinc Halah",
        "https://variety.com/wp-content/uploads/2021/04/Avatar.jpg"
    )
) {
    override fun obtainEvent(viewEvent: HomeEvent) {
        when(viewEvent){
            HomeEvent.UserProfileClicked -> showUserProfile()
        }
    }

    private fun showUserProfile() {
        viewAction = HomeAction.ShowUserProfile
    }

}