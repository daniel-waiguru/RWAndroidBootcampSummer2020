package tech.danielwaiguru.moviesapp.networking

import retrofit2.http.GET
import retrofit2.http.Query
import tech.danielwaiguru.moviesapp.BuildConfig
import tech.danielwaiguru.moviesapp.models.response.MovieResponse

/**
 * Retrofit powered api calls to a web service
 */
interface MoviesApiService {
    companion object{
        private const val API_KEY = BuildConfig.key
    }
    @GET("/3/movie/popular")
    suspend fun getAllMovies(
        @Query("api_key")
        api_key: String = API_KEY
    ): MovieResponse
}