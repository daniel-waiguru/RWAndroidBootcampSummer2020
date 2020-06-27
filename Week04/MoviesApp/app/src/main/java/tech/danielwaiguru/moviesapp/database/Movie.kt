package tech.danielwaiguru.moviesapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class Movie(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val release_date: String,
    val title: String,
    val summary: String,
    val poster: Int
)