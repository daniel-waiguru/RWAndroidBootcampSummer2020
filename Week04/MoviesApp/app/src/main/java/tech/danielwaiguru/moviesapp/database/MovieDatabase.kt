package tech.danielwaiguru.moviesapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import tech.danielwaiguru.moviesapp.models.User

@Database(entities = [Movie::class, User::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase(){
    abstract fun movieDao(): MovieDao
    abstract fun userDao(): UserDao
    companion object{
        @Volatile
        private var INSTANCE: MovieDatabase? = null

        /**
         * Singleton database instance
         */
        fun getDatabaseInstance(context: Context): MovieDatabase{
            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MovieDatabase::class.java,
                        "movies.db"
                    )
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}