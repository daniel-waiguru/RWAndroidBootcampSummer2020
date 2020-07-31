package tech.danielwaiguru.moviesapp.di

import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.named
import org.koin.dsl.module

val coroutineModule = module {
    single(named("Background")) { Dispatchers.Default }
    single(named("UI")) { Dispatchers.Main }
    single(named("IO")) { Dispatchers.IO }
}