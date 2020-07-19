package tech.danielwaiguru.moviesapp.models.response

import kotlinx.serialization.Serializable
import tech.danielwaiguru.moviesapp.database.Movie


data class MovieResponse(
    val movies : List<Movie>
)