package tech.danielwaiguru.moviesapp.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.rules.TestRule
import org.mockito.Mock
import tech.danielwaiguru.moviesapp.MovieApp
import tech.danielwaiguru.moviesapp.repositories.MovieRepository

class MovieViewModelTest {
    private lateinit var movieViewModel: MovieViewModel
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
    @Mock
    lateinit var movieRepository: MovieRepository
    @Before
    fun setup(){
        movieRepository = MovieApp.movieRepository
        movieViewModel = MovieViewModel(movieRepository)
    }
}