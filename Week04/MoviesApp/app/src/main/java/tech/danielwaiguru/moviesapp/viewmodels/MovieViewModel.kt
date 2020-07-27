package tech.danielwaiguru.moviesapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import tech.danielwaiguru.moviesapp.repositories.MovieRepository

class MovieViewModel(private val movieRepository: MovieRepository): ViewModel() {

    private val movies = movieRepository.movies
    fun getAllMovies() = movies

    fun fetchMovies() = viewModelScope.launch {
        movieRepository.fetchMovies()
    }
}