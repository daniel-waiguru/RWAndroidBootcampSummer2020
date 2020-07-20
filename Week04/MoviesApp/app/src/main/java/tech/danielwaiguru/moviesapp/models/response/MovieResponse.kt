package tech.danielwaiguru.moviesapp.models.response

import com.squareup.moshi.Json
import kotlinx.serialization.Serializable
import tech.danielwaiguru.moviesapp.database.Movie


data class MovieResponse(
    @field:Json(name = "results") val movies : List<Movie>
)