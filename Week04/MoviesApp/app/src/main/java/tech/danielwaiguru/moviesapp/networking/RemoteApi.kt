package tech.danielwaiguru.moviesapp.networking

import tech.danielwaiguru.moviesapp.database.Movie
import tech.danielwaiguru.moviesapp.models.Failure
import tech.danielwaiguru.moviesapp.models.*

class RemoteApi(private val moviesApiService: MoviesApiService) {
    suspend fun getPopularMovies(page: Int): Result<List<Movie>> =
        try {
            val response = moviesApiService.getAllMovies(page = page).movies
            Success(response)
        }
        catch (error: Throwable){
            Failure(error)
        }
    suspend fun searchMovie(searchTerm: String): Result<List<Movie>> =
        try {
            val searchResponse = moviesApiService.searchMovie(searchTerm = searchTerm).movies
            Success(searchResponse)
        }
        catch (error: Throwable){
            Failure(error)
        }
}