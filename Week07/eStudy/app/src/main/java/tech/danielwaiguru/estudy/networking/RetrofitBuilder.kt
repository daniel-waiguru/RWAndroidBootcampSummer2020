package tech.danielwaiguru.estudy.networking

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


const val BASE_URL = "https://774906.youcanlearnit.net"
const val IMAGES_URL = "$BASE_URL/images"

/**
 * HttpClient instance
 */
fun okHttpClient(): OkHttpClient =
    OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

fun retrofitBuilder(): Retrofit{
    return Retrofit.Builder()
        .client(okHttpClient())
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
}
fun buildServiceApi(): MonsterApiService =
    retrofitBuilder().create(MonsterApiService::class.java)