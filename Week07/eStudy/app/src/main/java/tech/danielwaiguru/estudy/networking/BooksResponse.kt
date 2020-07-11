package tech.danielwaiguru.estudy.networking

import tech.danielwaiguru.estudy.models.Book

data class BooksResponse (
    val books: List<Book>
)