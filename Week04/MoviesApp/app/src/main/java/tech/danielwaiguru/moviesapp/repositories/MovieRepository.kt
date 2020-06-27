package tech.danielwaiguru.moviesapp.repositories

import tech.danielwaiguru.moviesapp.database.MovieDao

class MovieRepository(private val movieDao: MovieDao) {
    val allMovies = movieDao.getAllMovies()

}