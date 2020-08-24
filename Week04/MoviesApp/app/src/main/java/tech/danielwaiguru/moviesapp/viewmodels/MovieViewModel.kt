package tech.danielwaiguru.moviesapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject
import tech.danielwaiguru.moviesapp.repositories.MovieRepository

class MovieViewModel : ViewModel(), KoinComponent {
    private val movieRepository: MovieRepository by inject()
    var page = 1
    private val movies = movieRepository.movies
    fun getAllMovies() = movies

    fun fetchMovies() = viewModelScope.launch {
        movieRepository.fetchMovies(page = page)
        page++
    }
}