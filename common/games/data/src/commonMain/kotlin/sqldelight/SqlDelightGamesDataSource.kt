package sqldelight

import DbDriverFactory
import com.observer.playzone.GAMEDBPLAYZONE


class SqlDelightGamesDataSource(private val driverFactory : DbDriverFactory) {

	suspend fun test() {
		val database = GAMEDBPLAYZONE(driverFactory.provideDbDriver(GAMEDBPLAYZONE.Schema))

	}
}