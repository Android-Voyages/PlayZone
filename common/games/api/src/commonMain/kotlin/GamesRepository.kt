import models.Game


interface GamesRepository {
    suspend fun fetchAllGames(token : String): List<Game>
    suspend fun searchGame(query: String,token : String): List<Game>

    suspend fun createGame(token: String,info: CreateGameInfo)
}