package admin.creategame.model

sealed class AdminCreateGameEvent{
	data class TitleChanged(val value: String): AdminCreateGameEvent()
	data class DescriptionChanged(val value: String): AdminCreateGameEvent()
	data class VersionChanged(val value: String): AdminCreateGameEvent()
	data class SizeChanged(val value: String): AdminCreateGameEvent()

	object SubmitChanges: AdminCreateGameEvent()
}