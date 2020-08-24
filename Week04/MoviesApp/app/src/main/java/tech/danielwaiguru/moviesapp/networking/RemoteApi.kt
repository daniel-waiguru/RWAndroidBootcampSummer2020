package tech.danielwaiguru.moviesapp.networking

import org.koin.core.KoinComponent
import org.koin.core.inject
import tech.danielwaiguru.moviesapp.database.Movie
import tech.danielwaiguru.moviesapp.models.Failure
import tech.danielwaiguru.moviesapp.models.Result
import tech.danielwaiguru.moviesapp.models.Success

class RemoteApi : KoinComponent {
    private val moviesApiService: MoviesApiService by inject()
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