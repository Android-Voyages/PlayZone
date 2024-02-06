import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.direct
import org.kodein.di.singleton
import java.lang.module.Configuration

object PlatformSdk {
    fun init(
        configuration: PlatformConfiguration
    ) {
        val umbrellaModule = DI.Module(
            name = "umbrella",
            init = {
                bind<PlatformConfiguration>() with singleton { configuration }
            }
        )

        Inject.createDependencies(
            DI {
                importAll(
                    coreModule,
                    gamesModule,
                    umbrellaModule
                )
            }.direct
        )
    }
}