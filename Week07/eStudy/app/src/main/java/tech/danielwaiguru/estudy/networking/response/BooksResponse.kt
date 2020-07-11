package tech.danielwaiguru.estudy.networking.response

import kotlinx.serialization.Serializable
import tech.danielwaiguru.estudy.models.Book

@Serializable
data class BooksResponse (
    val books: List<Book>
)