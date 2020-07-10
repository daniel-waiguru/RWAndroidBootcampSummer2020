package tech.danielwaiguru.estudy.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class Book(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val volumeInfo: VolumeInfo,
    val publisher: String,
    val publishedDate: String,
    val description: String,
    val averageRating: String,
    val imageLinks: List<String>
)