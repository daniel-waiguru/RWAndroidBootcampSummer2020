package tech.danielwaiguru.moviesapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import tech.danielwaiguru.moviesapp.database.Movie
import tech.danielwaiguru.moviesapp.repositories.MovieRepository

class MovieViewModel(private val movieRepository: MovieRepository): ViewModel() {
    val allMovies: MutableLiveData<List<Movie>> = movieRepository.allMovies

}