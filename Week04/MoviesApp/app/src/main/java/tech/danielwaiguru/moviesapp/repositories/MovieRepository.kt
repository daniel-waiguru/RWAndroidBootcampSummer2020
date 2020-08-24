package tech.danielwaiguru.moviesapp.repositories

import android.util.Log
import org.koin.core.KoinComponent
import org.koin.core.inject
import tech.danielwaiguru.moviesapp.database.Movie
import tech.danielwaiguru.moviesapp.database.MovieDao
import tech.danielwaiguru.moviesapp.models.Success
import tech.danielwaiguru.moviesapp.networking.RemoteApi

open class MovieRepository: KoinComponent {
    private val moviesDao: MovieDao by inject()
    private val remoteApi: RemoteApi by inject()
    val movies = moviesDao.getAllMovies()
    suspend fun fetchMovies(page: Int){
        val result = remoteApi.getPopularMovies(page = page)
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
    suspend fun searchMovie(searchTerm: String){
        val result = remoteApi.searchMovie(searchTerm = searchTerm)
        if (result is Success){

        }
    }
}