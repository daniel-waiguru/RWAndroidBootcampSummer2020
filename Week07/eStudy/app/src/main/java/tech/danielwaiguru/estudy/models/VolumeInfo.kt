package tech.danielwaiguru.estudy.models

import androidx.room.Embedded
import kotlinx.serialization.Serializable

@Serializable
data class VolumeInfo(
    val title: String,
    /*@Embedded
    val authors: Authors,*/
    val publisher: String,
    val publishedDate: String,
    val description: String,
    val printType: String,
    val mainCategory: String,
    @Embedded
    val imageLinks: ImageLinks
)