package tech.danielwaiguru.estudy.networking

import tech.danielwaiguru.estudy.models.Book

class RemoteApi {
    fun getBooks(): Result<List<Book>> =
        try {
            val data = BooksApiServiceBuilder.booksApi.getBooks()
            Success(data.books)
        }
        catch (error: Throwable){
            Failure(error)
        }
}