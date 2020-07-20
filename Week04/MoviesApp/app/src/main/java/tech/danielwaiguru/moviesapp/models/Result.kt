package tech.danielwaiguru.moviesapp.models

import tech.danielwaiguru.moviesapp.database.Movie

sealed class Result<out T: Any>

data class Success<out T: Any>(val data: List<Movie>): Result<T>()

data class Failure(val error: Throwable?): Result<Nothing>()