import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import ktor.models.KtorSearchGame
import models.Game

class KtorGamesDataSource(private val httpClient: HttpClient) {
    suspend fun fetchAllGames(): List<KtorSearchGame> {
        return httpClient.post {
            header("Bearer-Authorization", "Bearer token")

            url {
                path("games/search")
                setBody(KtorSearchRequest(searchRequest = ""))
            }
            TODO("вставить токен")
        }.body()
    }

    suspend fun searchGame(query: String): Game {
        return Game(gameId = "", tittle = "")
    }
}