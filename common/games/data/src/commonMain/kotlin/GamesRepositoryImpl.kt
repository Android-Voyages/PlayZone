import ktor.models.mapToGame
import models.Game
import sqldelight.SqlDelightGamesDataSource

class GamesRepositoryImpl(
	private val remoteDataSource : KtorGamesDataSource,
	private val localDataSource : SqlDelightGamesDataSource
) : GamesRepository {

	override suspend fun fetchAllGames(token : String) : List<Game> {
		return remoteDataSource.fetchAllGames(token).map { it.mapToGame() }
	}

	override suspend fun searchGame(query : String, token : String) : List<Game> {
		return remoteDataSource.searchGame(query = query, token = token).map { it.mapToGame() }
	}

	override suspend fun createGame(token : String, info : CreateGameInfo) {
		return remoteDataSource.createGame(token, info)
	}
}
