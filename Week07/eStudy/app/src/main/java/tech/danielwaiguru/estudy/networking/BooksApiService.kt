package tech.danielwaiguru.estudy.networking

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import tech.danielwaiguru.estudy.BuildConfig

const val API_KEY : String = BuildConfig.key
interface BooksApiService {

    @GET("/android?q=android")
    fun getBooks(@Query("api_key") api_key: String = API_KEY ): BooksResponse

    @GET("/books/v1/volumes?langRestrict=en&maxResults=40&printType=books")
    fun searchBooks(@Query("q") search_term: String, @Query("api_key")
    api_key: String = API_KEY): Call<BooksResponse>
}