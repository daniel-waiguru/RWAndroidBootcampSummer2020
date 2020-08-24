package tech.danielwaiguru.moviesapp.di

import org.koin.dsl.module
import tech.danielwaiguru.moviesapp.repositories.MovieRepository

val repositoryModule = module {
    single { MovieRepository() }
}