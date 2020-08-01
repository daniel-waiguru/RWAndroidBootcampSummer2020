package tech.danielwaiguru.moviesapp.di

import org.koin.dsl.module
import tech.danielwaiguru.moviesapp.repositories.MovieRepository
import tech.danielwaiguru.moviesapp.viewmodels.MovieViewModel

val viewModelModule = module {
    fun provideMovieViewModel(movieRepository: MovieRepository): MovieViewModel{
        return MovieViewModel(movieRepository)
    }
    single { provideMovieViewModel(get()) }
}