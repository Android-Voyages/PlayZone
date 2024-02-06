package ktor.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import models.Game

@Serializable
data class KtorSearchGame(
    @SerialName("gameId") val gameId: String,
    @SerialName("tittle") val tittle: String,
    @SerialName("description") val description: String,
    @SerialName("version") val version: String,
    @SerialName("size") val size: String

)

fun KtorSearchGame.mapToGame():Game = Game(
    gameId = gameId,
    tittle = tittle
)