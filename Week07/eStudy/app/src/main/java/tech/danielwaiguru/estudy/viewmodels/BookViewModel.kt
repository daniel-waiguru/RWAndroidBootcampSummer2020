package tech.danielwaiguru.estudy.viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import tech.danielwaiguru.estudy.database.BookDatabase
import tech.danielwaiguru.estudy.models.Book
import tech.danielwaiguru.estudy.repositories.BookRepository

class BookViewModel(context: Context): ViewModel() {
    private val bookRepository: BookRepository
    val allBooks: LiveData<List<Book>>
    init {
        val bookDao = BookDatabase.getDatabaseInstance(context).bookDao()
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