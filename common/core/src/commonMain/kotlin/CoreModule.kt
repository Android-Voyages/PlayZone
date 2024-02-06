
import ktor.ktorModule
import org.kodein.di.DI
import serializationModule

val coreModule = DI.Module("coreModule"){
    importAll(
        serializationModule,
        databaseModule,
        ktorModule,
        coroutineModule
    )
}