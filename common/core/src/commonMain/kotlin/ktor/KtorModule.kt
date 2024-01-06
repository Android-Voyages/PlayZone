package ktor

import HttpEngineFactory
import io.ktor.client.*
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.json.*
import io.ktor.client.plugins.kotlinx.serializer.KotlinxSerializer
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

internal val ktorModule = DI.Module("ktorModule") {
    bind<HttpClient> with singleton {
        HttpClient(HttpEngineFactory().createEngine()) {
            install(Logging) {
                logger = Logger.SIMPLE
                level = LogLevel.ALL
            }
            install(JsonPlugin) {
                serializer = KotlinxSerializer(json = instance())
            }
            install(HttpTimeout) {
                connectTimeoutMillis = 15000
                requestTimeoutMillis = 30000
            }
        }
    }
}