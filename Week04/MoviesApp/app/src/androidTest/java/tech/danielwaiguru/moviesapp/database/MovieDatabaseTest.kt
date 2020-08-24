package tech.danielwaiguru.moviesapp.database

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class MovieDatabaseTest {
    @get: Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
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
    fun closeDatabaseConnection(){
        movieDatabase.close()
    }
    @Test
    fun writeAndReadMovieDatabase() = runBlockingTest {
        val preRetrieve = movieDao.getAllMovies().getOrAwaitValue()
        val movies = listOf(
            Movie(id = 1, poster_path =
            "https://pmcdeadline2.files.wordpress.com/2018/01/silicon-valley.jpg?w=1024",
                original_language = "en", title = "Test Movie",
                vote_average = 3.5, release_date = "2020-07-26", overview = "This is a test Movie"),
            Movie(id = 2,poster_path =
            "https://pmctvline2.files.wordpress.com/2019/12/silicon-valley.png?w=620",
                original_language = "es", title = "Test Movie 2",
                vote_average = 3.0 , release_date = "2020-07-26",
                overview = "This is a test Movie 2")
        )
        movieDao.insertMovie(movies)
        val postRetrieve = movieDao.getAllMovies().getOrAwaitValue()
        val difference = postRetrieve.minus(preRetrieve)
        assertEquals(movies, difference)
    }
    @Test
    fun deleteAllMovies() = runBlockingTest {
        val movies = listOf(
                Movie(id = 1, poster_path =
                "https://pmcdeadline2.files.wordpress.com/2018/01/silicon-valley.jpg?w=1024",
                    original_language = "en", title = "Test Movie",
                    vote_average = 3.5, release_date = "2020-07-26", overview = "This is a test Movie"),
        Movie(id = 2,poster_path =
        "https://pmctvline2.files.wordpress.com/2019/12/silicon-valley.png?w=620",
            original_language = "es", title = "Test Movie 2",
            vote_average = 3.0 , release_date = "2020-07-26",
            overview = "This is a test Movie 2")
        )
        movieDao.insertMovie(movies)
        movieDao.deleteAllMovies()
        val moviesList = movieDao.getAllMovies().getOrAwaitValue()
        assertEquals(emptyList<Movie>(), moviesList)
    }
}