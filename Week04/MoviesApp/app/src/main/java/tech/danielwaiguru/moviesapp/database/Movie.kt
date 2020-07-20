package tech.danielwaiguru.moviesapp.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "movie")
data class Movie(
    @PrimaryKey(autoGenerate = true)
    @field:Json(name = "id") val id: Int = 0,
    @field:Json(name = "poster_path") val poster_path: String,
    @field:Json(name = "original_language") val original_language: String,
    @field:Json(name = "title") val title: String,
    @field:Json(name = "vote_average") val vote_average: Double,
    @field:Json(name = "overview") val overview: String,
    @field:Json(name = "release_date")val release_date: String
): Parcelable