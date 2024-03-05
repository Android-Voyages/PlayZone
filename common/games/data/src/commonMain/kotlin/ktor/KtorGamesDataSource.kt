
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import ktor.models.KtorSearchGame

class KtorGamesDataSource(private val httpClient: HttpClient) {
    suspend fun fetchAllGames(token: String): List<KtorSearchGame> {
        return httpClient.post {
            header("Bearer-Authorization", token)

            url {
                path("games/search")
                setBody(KtorSearchRequest(searchQuery = ""))
            }
        }.body()
    }

    suspend fun searchGame(token: String,query: String): List<KtorSearchGame> {
        return httpClient.post {
            header("Bearer-Authorization", token)

            url {
                path("games/search")
                setBody(KtorSearchRequest(searchQuery = query))
            }
        }.body()
    }

    suspend fun createGame(token: String,info : CreateGameInfo){
        return httpClient.post {
            header("Bearer-Authorization",token)

            url {
                path("games/create")
                setBody(info)
            }
        }.body()
    }
}