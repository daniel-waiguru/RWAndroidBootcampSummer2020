package tech.danielwaiguru.estudy.viewmodels

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import tech.danielwaiguru.estudy.database.BookDatabase
import tech.danielwaiguru.estudy.models.Book
import tech.danielwaiguru.estudy.repositories.BookRepository

class BookViewModel(application: Application): AndroidViewModel(application) {
    private val bookRepository: BookRepository
    val allBooks: LiveData<List<Book>>
    init {
        val bookDao = BookDatabase.getDatabaseInstance(application).bookDao()
        bookRepository = BookRepository(bookDao)
        allBooks = bookRepository.allBooks
    }
    fun insert(book: List<Book>) = viewModelScope.launch {
        bookRepository.insert(book)
    }
    fun delete(book: Book) = viewModelScope.launch {
        bookRepository.delete(book)
    }
}