package tech.danielwaiguru.estudy.models

data class VolumeInfo(
    val title: String,
    val authors: Authors,
    val publisher: String,
    val publishedDate: String,
    val description: String,
    val printType: String,
    val mainCategory: String,
    val imageLinks: ImageLinks
)