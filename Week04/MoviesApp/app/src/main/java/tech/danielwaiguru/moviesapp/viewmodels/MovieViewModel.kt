package tech.danielwaiguru.moviesapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import tech.danielwaiguru.moviesapp.database.Movie
import tech.danielwaiguru.moviesapp.database.MovieDatabase
import tech.danielwaiguru.moviesapp.repositories.MovieRepository

class MovieViewModel(application: Application): AndroidViewModel(application) {
    private val movieRepository: MovieRepository = MovieRepository(application)
    val allMovies = movieRepository.allMovies
}