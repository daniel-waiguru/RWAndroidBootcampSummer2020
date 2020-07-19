package tech.danielwaiguru.moviesapp.networking

import tech.danielwaiguru.moviesapp.database.Movie
import tech.danielwaiguru.moviesapp.models.Failure
import tech.danielwaiguru.moviesapp.models.*

class RemoteApi(private val moviesApiService: MoviesApiService) {
    suspend fun getPopularMovies(): Result<List<Movie>> =
        try {
            val response = moviesApiService.getAllMovies()
            Success(response.movies)
        }
        catch (error: Throwable){
            Failure(error)
        }
}