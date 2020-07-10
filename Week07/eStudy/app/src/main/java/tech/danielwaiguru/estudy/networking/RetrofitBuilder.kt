package tech.danielwaiguru.estudy.networking

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

const val API_KEY = "AIzaSyDPKiHfvrm0jLom5CCkODACXf1XwO04mhY"
const val BASE_URL = "https://www.googleapis.com/books/v1/volumes"

/**
 * HttpClient instance
 */
private val okHttpClient: OkHttpClient =
    OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

fun retrofitBuilder(): Retrofit{
    val contentType = "application/json".toMediaType()
    return Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(Json.nonstrict.asConverterFactory(contentType))
        .baseUrl(BASE_URL)
        .build()
}

object BooksApiServiceBuilder{
    val booksApi by lazy {
        retrofitBuilder().create(BooksApiService::class.java)
    }
}