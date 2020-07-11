package tech.danielwaiguru.estudy.networking

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import tech.danielwaiguru.estudy.BuildConfig
import tech.danielwaiguru.estudy.networking.response.BooksResponse


interface BooksApiService {
    companion object{
        const val API_KEY : String = BuildConfig.key
    }

    @GET("?q=android%20programming")
    suspend fun getBooks(): BooksResponse

    @GET("/books/v1/volumes?langRestrict=en&maxResults=40&printType=books")
    fun searchBooks(@Query("q") search_term: String, @Query("api_key")
    api_key: String = API_KEY): Call<BooksResponse>
}