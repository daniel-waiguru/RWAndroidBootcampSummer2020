package tech.danielwaiguru.estudy.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import tech.danielwaiguru.estudy.models.Book

@Dao
interface BookDao {
    @Insert
    suspend fun insertBook(book: List<Book>)
    @Query("SELECT * FROM books")
    fun getAllBooks(): LiveData<List<Book>>
    @Delete
    suspend fun deleteBook(book: Book)
}