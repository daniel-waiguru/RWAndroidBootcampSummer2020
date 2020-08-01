package tech.danielwaiguru.moviesapp.di

import android.app.Application
import androidx.room.Room
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import tech.danielwaiguru.moviesapp.database.MovieDao
import tech.danielwaiguru.moviesapp.database.MovieDatabase

val databaseModule = module {
    fun provideMovieDatabase(application: Application): MovieDatabase{
        return Room.databaseBuilder(application, MovieDatabase::class.java, "moviesdatabase")
            .fallbackToDestructiveMigration()
            .build()
    }
    fun provideMovieDao(database: MovieDatabase):MovieDao =
        database.movieDao()
    single { provideMovieDatabase(androidApplication()) }
    single { provideMovieDao(get()) }
}