import models.Game

class GamesRepositoryImpl: GamesRepository {
    override suspend fun fetchAllGames(): List<Game> {
        TODO("Not yet implemented")
    }

    override suspend fun searchGame(query: String): Game {
        TODO("Not yet implemented")
    }
}