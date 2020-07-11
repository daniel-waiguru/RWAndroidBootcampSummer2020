package tech.danielwaiguru.estudy.repositories

import tech.danielwaiguru.estudy.database.BookDao
import tech.danielwaiguru.estudy.models.Book

class BookRepository(private val bookDao: BookDao) {
    val allBooks = bookDao.getAllBooks()

    suspend fun insert(book: List<Book>){
        bookDao.insertBook(book)
    }
    suspend fun delete(book: Book){
        bookDao.deleteBook(book)
    }
}