package tech.danielwaiguru.moviesapp.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import tech.danielwaiguru.moviesapp.MovieApp
import tech.danielwaiguru.moviesapp.database.Movie
import tech.danielwaiguru.moviesapp.repositories.MovieRepository

class MovieViewModelTest {
    private lateinit var movieViewModel: MovieViewModel
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
    @Mock
    lateinit var movieRepository: MovieRepository
    @Mock
    lateinit var observer: Observer<List<Movie>>
    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        movieRepository = MovieApp.movieRepository
        movieViewModel = MovieViewModel(movieRepository)
    }
    @Test
    fun moviesLiveData(){
        movieViewModel.getAllMovies().observeForever(observer)
    }
}