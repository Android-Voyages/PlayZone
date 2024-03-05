package admin.creategame.model

data class AdminCreateGameViewState(
	val title : String = "",
	val description : String = "",
	val version : String = "",
	val size : String = "",
	val isSending : Boolean = false
)