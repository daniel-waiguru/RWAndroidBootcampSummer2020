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
                            1,
                            "2020-02-13",
                            "First Man",
                            "A sci-fi Tv series of the first human AI child",
                            R.drawable.revenge
                        ),
                        Movie(
                            2,
                            "2020-01-23",
                            "Alex Rider",
                            "A Tv series, Genre action, adventure, family, thriller, English language is used",
                            R.drawable.alexrider
                        ),
                        Movie(
                            3,
                            "2020-01-23",
                            "Crossings Sword",
                            "A 2020 animation, adventure and comedy english Tv series",
                            R.drawable.crossings
                        ),
                        Movie(
                            4,
                            "2020-01-23",
                            "Most Dangerous Game",
                            "A 2020 action and thriller Tv series season one 15 complete episodes",
                            R.drawable.dangergame
                        ),
                        Movie(
                            5,
                            "2014-06-21",
                            "From Dusk Till Down",
                            "A 2014 action, thriller and drama Tv series recorded in english",
                            R.drawable.deskdawn
                        ),
                        Movie(
                            6,
                            "2018-01-12",
                            "Roswell New Mexico",
                            "A 2018 Tv series recorded in mexico",
                            R.drawable.roswell
                        ),
                        Movie(
                            7,
                            "2014-07-3",
                            "The Search",
                            "A 2014 Tv series, Genre dram and war, english language used",
                            R.drawable.search
                        ),
                        Movie(
                            8,
                            "2019-11-23",
                            "The Titan Game",
                            "A 2019 reality-tv Tv series recorded in english",
                            R.drawable.titan
                        ),
                        Movie(
                            9,
                            "2020-01-23",
                            "Alex Rider",
                            "A comedy Tv series season one complete",
                            R.drawable.alexrider
                        ),
                        Movie(
                            10,
                            "2020-06-23",
                            "Chissys Court",
                            "A 2020 short and reality-tv season one tv series",
                            R.drawable.court
                        ),
                        Movie(
                            11,
                            "2020-06-01",
                            "Cursed",
                            "A drama and fantasy Tv series season one complete season one",
                            R.drawable.cursed
                        ),
                        Movie(
                            12,
                            "2020-01-23",
                            "Good Behavior",
                            "A drama Tv series season one complete with ten episodes",
                            R.drawable.goodbehavior
                        ),
                        Movie(
                            13,
                            "2020-03-2",
                            "Snow piercer",
                            "A 2020 action, drama, sci-fi and thriller Tv series recorded in english",
                            R.drawable.snow
                        )


                    )
                    movieDao.insert(movieList)
                }
            }
        }
    }
}