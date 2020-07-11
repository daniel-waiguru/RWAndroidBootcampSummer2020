package tech.danielwaiguru.estudy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tech.danielwaiguru.estudy.adapters.BookAdapter
import tech.danielwaiguru.estudy.models.Book
import tech.danielwaiguru.estudy.networking.BooksApiServiceBuilder
import tech.danielwaiguru.estudy.networking.BooksResponse
import tech.danielwaiguru.estudy.networking.Failure
import tech.danielwaiguru.estudy.networking.Result
import tech.danielwaiguru.estudy.networking.Success
import tech.danielwaiguru.estudy.viewmodels.BookViewModel

class MainActivity : AppCompatActivity() {
    private val bookAdapter by lazy {
        BookAdapter()
    }
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
    }
    private fun setUpRecyclerView(){
        books_rv.layoutManager = LinearLayoutManager(this)
        books_rv.adapter = bookAdapter
    }
}