
import ktor.ktorModule
import org.kodein.di.DI
import serializationModule
import settings.settingsModule

val coreModule = DI.Module("coreModule"){
    importAll(
        serializationModule,
       // databaseModule,
        ktorModule,
        coroutineModule,
        settingsModule
    )
}