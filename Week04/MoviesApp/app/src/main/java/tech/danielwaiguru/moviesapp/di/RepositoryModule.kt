package tech.danielwaiguru.moviesapp.di

import org.koin.dsl.module
import tech.danielwaiguru.moviesapp.database.MovieDao
import tech.danielwaiguru.moviesapp.networking.RemoteApi
import tech.danielwaiguru.moviesapp.repositories.MovieRepository

val repositoryModule = module {
    fun provideMovieRepository(movieDao: MovieDao, remoteApi: RemoteApi): MovieRepository{
        return MovieRepository(movieDao, remoteApi)
    }
    single { provideMovieRepository(get(), get()) }
}