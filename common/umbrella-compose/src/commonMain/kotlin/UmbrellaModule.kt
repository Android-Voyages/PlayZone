import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val umbrellaModule = DI.Module(
    name = "umbrella",
    init = {
        bind<PlatformConfiguration>() with singleton { instance() }
    }

)