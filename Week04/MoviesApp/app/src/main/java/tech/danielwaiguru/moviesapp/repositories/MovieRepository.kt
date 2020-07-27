package tech.danielwaiguru.moviesapp.repositories

import android.util.Log
import tech.danielwaiguru.moviesapp.database.Movie
import tech.danielwaiguru.moviesapp.database.MovieDao
import tech.danielwaiguru.moviesapp.models.Success
import tech.danielwaiguru.moviesapp.networking.RemoteApi

open class MovieRepository(private val moviesDao: MovieDao, private val remoteApi: RemoteApi) {
    val movies = moviesDao.getAllMovies()
    suspend fun fetchMovies(){
        val result = remoteApi.getPopularMovies()
        if (result is Success){
            storeMovies(result.data)
        }
        else{
            Log.d("API", "Server Error")
        }
    }
    private suspend fun storeMovies(movies: List<Movie>){
        moviesDao.insertMovie(movies)
    }
}