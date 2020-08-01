package tech.danielwaiguru.moviesapp.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import tech.danielwaiguru.moviesapp.networking.MoviesApiService
import tech.danielwaiguru.moviesapp.networking.RemoteApi

val networkMode = module {
    single(named("BASE_URL")) {
        "https://api.themoviedb.org"
    }
    single {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        interceptor
    }
    single {
        val client = OkHttpClient.Builder()
        if (BuildConfig.DEBUG){
            client.addInterceptor(get<HttpLoggingInterceptor>())
        }
        client.build()
    }

    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl(get<String>(named("BASE_URL")))
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
    single {
        get<Retrofit>().create(MoviesApiService::class.java)
    }
    single {
        RemoteApi()
    }
}