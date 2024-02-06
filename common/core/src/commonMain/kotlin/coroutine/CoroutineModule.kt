import coroutine.AppDispatchers
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

 val coroutineModule = DI.Module("coroutineModule"){
    bind<AppDispatchers>() with singleton {
        AppDispatchers()
    }
}