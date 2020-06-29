package tech.danielwaiguru.moviesapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import tech.danielwaiguru.moviesapp.R

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase(){
    abstract fun movieDao(): MovieDao

    companion object{
        @Volatile
        private var INSTANCE: MovieDatabase? = null

        /**
         * Singleton database instance
         */
        fun getDatabaseInstance(context: Context, scope: CoroutineScope): MovieDatabase{
            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MovieDatabase::class.java,
                        "movies.db"
                    ).addCallback(MovieDatabaseCallback(scope))
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
    private class MovieDatabaseCallback(private val scope: CoroutineScope): RoomDatabase.Callback()
    {
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    val movieDao = database.movieDao()
                    val movieList = mutableListOf(
                        Movie(
                            release_date = "2020-02-13",
                            title = "First Man",
                            summary = "A sci-fi Tv series of the first human AI child",
                            poster = R.drawable.revenge
                        ),
                        Movie(
                            release_date = "2020-01-23",
                            title = "Alex Rider",
                            summary = "A Tv series, Genre action, adventure, family, thriller, English language is used",
                            poster = R.drawable.alexrider
                        ),
                        Movie(

                            release_date = "2020-01-23",
                            title = "Crossings Sword",
                            summary = "A 2020 animation, adventure and comedy english Tv series",
                            poster = R.drawable.crossings
                        ),
                        Movie(

                            release_date = "2020-01-23",
                            title = "Most Dangerous Game",
                            summary = "A 2020 action and thriller Tv series season one 15 complete episodes",
                            poster = R.drawable.dangergame
                        ),
                        Movie(

                            release_date = "2014-06-21",
                            title = "From Dusk Till Down",
                            summary = "A 2014 action, thriller and drama Tv series recorded in english",
                            poster = R.drawable.deskdawn
                        ),
                        Movie(

                            release_date = "2018-01-12",
                            title = "Roswell New Mexico",
                            summary = "A 2018 Tv series recorded in mexico",
                            poster = R.drawable.roswell
                        ),
                        Movie(

                            release_date = "2014-07-3",
                            title = "The Search",
                            summary = "A 2014 Tv series, Genre dram and war, english language used",
                            poster = R.drawable.search
                        ),
                        Movie(

                            release_date = "2019-11-23",
                            title = "The Titan Game",
                            summary = "A 2019 reality-tv Tv series recorded in english",
                            poster = R.drawable.titan
                        ),
                        Movie(

                            release_date = "2020-01-23",
                            title = "Alex Rider",
                            summary = "A comedy Tv series season one complete",
                            poster = R.drawable.alexrider
                        ),
                        Movie(

                            release_date = "2020-06-23",
                            title = "Chissys Court",
                            summary = "A 2020 short and reality-tv season one tv series",
                            poster = R.drawable.court
                        ),
                        Movie(

                            release_date = "2020-06-01",
                            title = "Cursed",
                            summary = "A drama and fantasy Tv series season one complete season one",
                            poster = R.drawable.cursed
                        ),
                        Movie(

                            release_date = "2020-01-23",
                            title = "Good Behavior",
                            summary = "A drama Tv series season one complete with ten episodes",
                            poster = R.drawable.goodbehavior
                        ),
                        Movie(

                            release_date = "2020-03-2",
                            title = "Snow piercer",
                            summary = "A 2020 action, drama, sci-fi and thriller Tv series recorded in english",
                            poster = R.drawable.snow
                        )


                    )
                    movieDao.deleteAllMovies()
                    movieDao.insert(movieList)
                }
            }
        }
    }
}