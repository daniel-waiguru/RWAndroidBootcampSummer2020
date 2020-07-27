package tech.danielwaiguru.moviesapp.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class MovieDatabaseTest {
    private lateinit var movieDatabase: MovieDatabase
    private lateinit var movieDao: MovieDao
    @Before
    fun setup(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        movieDatabase = Room.inMemoryDatabaseBuilder(
            context,
            MovieDatabase::class.java
        ).allowMainThreadQueries()
            .build()
        movieDao = movieDatabase.movieDao()
    }
    @After
    @Throws(IOException::class)
    fun closeDatabaseConnection(){
        movieDatabase.close()
    }
    @Test
    @Throws(Exception::class)
    fun writeAndReadMovieDatabase() = runBlocking {
        val preRetrieve = movieDao.getAllMovies().value!!
        val movies = listOf(
            Movie(id = 1, poster_path = "https://pmcdeadline2.files.wordpress.com/2018/01/silicon-valley.jpg?w=1024", original_language = "en", title = "Test Movie",
                vote_average = 3.5, release_date = "2020-07-26", overview = "This is a test Movie"),
            Movie(id = 2,poster_path = "https://pmctvline2.files.wordpress.com/2019/12/silicon-valley.png?w=620", original_language = "es", title = "Test Movie 2",
                vote_average = 3.0 , release_date = "2020-07-26", overview = "This is a test Movie 2")
        )
        movieDao.insertMovie(movies)
        val postRetrieve = movieDao.getAllMovies().value!!
        val difference = postRetrieve.minus(preRetrieve)
        assertEquals(movies, difference)
    }
}