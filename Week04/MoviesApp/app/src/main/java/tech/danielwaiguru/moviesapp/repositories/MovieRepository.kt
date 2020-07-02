package tech.danielwaiguru.moviesapp.repositories

import tech.danielwaiguru.moviesapp.database.MovieDao

class MovieRepository(movieDao: MovieDao) {
    val allMovies = movieDao.getAllMovies()

}