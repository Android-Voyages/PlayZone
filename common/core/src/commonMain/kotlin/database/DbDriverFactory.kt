import com.squareup.sqldelight.db.SqlDriver

expect class DbDriverFactory(platformConfiguration: PlatformConfiguration){
    fun createDriver(schema: SqlDriver.Schema,name:String): SqlDriver
}