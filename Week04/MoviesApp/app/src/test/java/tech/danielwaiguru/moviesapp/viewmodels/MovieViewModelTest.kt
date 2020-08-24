package tech.danielwaiguru.moviesapp.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.github.testcoroutinesrule.TestCoroutineRule
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.MockitoAnnotations
import tech.danielwaiguru.moviesapp.repositories.MovieRepository


@ExperimentalCoroutinesApi
class MovieViewModelTest {
    @get:Rule
    val testCoroutineRule = TestCoroutineRule()
    @get:Rule
    val rule = InstantTaskExecutorRule()
    lateinit var movieViewModel: MovieViewModel
    private val movieRepository: MovieRepository = mock()
    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        movieViewModel = MovieViewModel(movieRepository)
    }
    @Test
    fun `test fetchMovies function that gets movies from api`() {
        testCoroutineRule.runBlockingTest {
            movieViewModel.fetchMovies()
            verify(movieRepository).fetchMovies(1)
        }
    }
    @Test
    fun `test getMovies function that gets movies from db`(){
        movieViewModel.getAllMovies()
        verify(movieRepository).movies
    }
}