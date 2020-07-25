package tech.danielwaiguru.moviesapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import tech.danielwaiguru.moviesapp.database.Movie
import tech.danielwaiguru.moviesapp.database.MovieDatabase
import tech.danielwaiguru.moviesapp.repositories.MovieRepository

class MovieViewModel(application: Application): AndroidViewModel(application) {
    val allMovies: MutableLiveData<List<Movie>>
    init {
        val movieRepository = MovieRepository(application)
        allMovies = movieRepository.allMovies
    }
}