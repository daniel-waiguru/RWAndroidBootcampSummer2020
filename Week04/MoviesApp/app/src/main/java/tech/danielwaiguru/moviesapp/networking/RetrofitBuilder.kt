package tech.danielwaiguru.moviesapp.networking

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://api.themoviedb.org"
private const val IMAGE_URL = "http://image.tmdb.org/t/p/w300/"
/**
 *OkHttp Builder
 */
private fun buildClient(): OkHttpClient =
    OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()
/**
 *Retrofit instance builder
 */
private fun retrofitInstance(): Retrofit {
    val contentType = "application/json".toMediaType()
    return Retrofit.Builder()
        .client(buildClient())
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
}
/**
 * Movies api service builder
 */
fun buildMovieApiService(): MoviesApiService =
    retrofitInstance().create(MoviesApiService::class.java)