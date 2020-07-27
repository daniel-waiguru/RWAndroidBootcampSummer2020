package tech.danielwaiguru.moviesapp.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import tech.danielwaiguru.moviesapp.database.Movie
import tech.danielwaiguru.moviesapp.repositories.MovieRepository
import tech.danielwaiguru.moviesapp.utils.CoroutineTestRule


@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
    lateinit var movieViewModel: MovieViewModel
    @ExperimentalCoroutinesApi
    @get:Rule
    val testCoroutineRule = CoroutineTestRule()
    lateinit var movieRepository: MovieRepository

    lateinit var observer: Observer<List<Movie>>
    private val movie = Movie(id = 1, poster_path = "", original_language = "en",
        title = "Test Movie", vote_average = 2.4,
        release_date = "2020-07-23", overview = "Test Movie overview")
    private val result = listOf(movie)
    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        movieRepository = mock(MovieRepository::class.java)
        movieViewModel = MovieViewModel(movieRepository)
    }

    @Test
    fun fetchMovies() = testCoroutineRule.testDispatcher.runBlockingTest {
        val movies = movieViewModel.fetchMovies()
        assertNotNull(movies)
    }
}