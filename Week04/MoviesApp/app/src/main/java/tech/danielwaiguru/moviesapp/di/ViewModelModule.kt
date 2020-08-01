package tech.danielwaiguru.moviesapp.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import tech.danielwaiguru.moviesapp.viewmodels.MovieViewModel

val viewModelModule = module {
    viewModel { MovieViewModel() }
}