package tech.danielwaiguru.moviesapp.repositories

import tech.danielwaiguru.moviesapp.database.Movie
import tech.danielwaiguru.moviesapp.database.MovieDao

class MovieRepository(private val movieDao: MovieDao) {
    val allMovies = movieDao.getAllMovies()
    suspend fun insert(movie: List<Movie>){
        movieDao.insert(movie)
    }
}