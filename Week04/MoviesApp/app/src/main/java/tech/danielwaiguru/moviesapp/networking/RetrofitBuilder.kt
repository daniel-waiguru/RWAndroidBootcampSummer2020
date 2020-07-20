package tech.danielwaiguru.moviesapp.networking

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://api.themoviedb.org"
const val IMAGE_URL = "https://image.tmdb.org/t/p/w500"
/**
 *OkHttp Builder
 */
private fun buildClient(): OkHttpClient =
    OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        })
        .build()
/**
 *Retrofit instance builder
 */
private fun retrofitInstance(): Retrofit {
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