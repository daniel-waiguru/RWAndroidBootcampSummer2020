package tech.danielwaiguru.moviesapp

import android.app.Application
import tech.danielwaiguru.moviesapp.networking.RemoteApi
import tech.danielwaiguru.moviesapp.networking.buildMovieApiService

class MovieApp: Application() {
    companion object{
        private lateinit var instance: MovieApp
        private val moviesApiService by lazy { buildMovieApiService() }
        val remoteApi by lazy { RemoteApi(moviesApiService) }
    }


    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}