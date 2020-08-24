package tech.danielwaiguru.moviesapp.di

import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module
import tech.danielwaiguru.moviesapp.repositories.UserPrefRepository

val prefsModule = module {
    scope(named("userPrefs")) {
        scoped {
            UserPrefRepository(androidContext())
        }
    }
}