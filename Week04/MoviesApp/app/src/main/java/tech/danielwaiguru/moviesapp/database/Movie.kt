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
    val release_date: String,
    val title: String,
    val summary: String,
    val poster: Int
): Parcelable