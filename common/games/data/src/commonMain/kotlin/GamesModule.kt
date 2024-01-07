import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

val gamesModule = DI.Module("gamesModule"){
    bind<GamesRepository>() with singleton {
        GamesRepositoryImpl()
    }
}