package tech.danielwaiguru.moviesapp.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "movie")
data class Movie(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val poster_path: String,
    val original_language: String,
    val title: String,
    val vote_average: Double,
    val overview: String,
    val release_date: String
): Parcelable