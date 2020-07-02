package tech.danielwaiguru.moviesapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import tech.danielwaiguru.moviesapp.database.Movie
import tech.danielwaiguru.moviesapp.database.MovieDatabase
import tech.danielwaiguru.moviesapp.repositories.MovieRepository

class MovieViewModel(application: Application): AndroidViewModel(application) {
    private val movieRepository: MovieRepository
    val allMovies: LiveData<List<Movie>>
    init {
        val movieDao = MovieDatabase.getDatabaseInstance(application, viewModelScope).movieDao()
        movieRepository = MovieRepository(movieDao)
        allMovies = movieRepository.allMovies
    }


}