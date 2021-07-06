package tech.danielwaiguru.moviesapp.di

import org.koin.dsl.module
import tech.danielwaiguru.moviesapp.repositories.MovieRepository
import tech.danielwaiguru.moviesapp.repositories.UserRepository

val repositoryModule = module {
    single { MovieRepository() }
    single { UserRepository() }
}