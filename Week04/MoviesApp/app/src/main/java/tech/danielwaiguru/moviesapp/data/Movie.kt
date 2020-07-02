package tech.danielwaiguru.moviesapp.data

data class Movie(
    val id: Int,
    val release_date: String,
    val title: String,
    val summary: String,
    val poster: Int
)