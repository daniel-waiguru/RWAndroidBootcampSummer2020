package tech.danielwaiguru.estudy

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import tech.danielwaiguru.estudy.adapters.BookAdapter
import tech.danielwaiguru.estudy.models.Book
import tech.danielwaiguru.estudy.networking.RemoteApi
import tech.danielwaiguru.estudy.networking.Success
import tech.danielwaiguru.estudy.viewmodels.BookViewModel

class MainActivity : AppCompatActivity() {
    private val bookAdapter by lazy {
        BookAdapter()
    }
    private val remoteApi = RemoteApi()
    private val bookViewModel by lazy {
        ViewModelProvider(this).get(BookViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecyclerView()
        bookViewModel.allBooks.observe(this, Observer {booksList ->
            booksList?.let {
                bookAdapter.submitList(it)
            }

        })
        getBooks()
    }
    private fun setUpRecyclerView(){
        books_rv.layoutManager = LinearLayoutManager(this)
        books_rv.adapter = bookAdapter
    }
    private fun getBooks(){
        val result = remoteApi.getBooks()
        if (result is Success){
            onBooksListReceived(result.data)
        }
        else{
            onGetBooksFailed()
        }
    }

    private fun onGetBooksFailed() {
        Toast.makeText(this, "Failed to get books", Toast.LENGTH_LONG).show()
    }

    private fun onBooksListReceived(data: List<Book>) {
        onBooksReceived(data)
    }

    private fun onBooksReceived(data: List<Book>) = bookViewModel.insert(data)
}