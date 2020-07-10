package tech.danielwaiguru.estudy

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import tech.danielwaiguru.estudy.adapters.BookAdapter
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
        bookViewModel.al
    }
    private fun setUpRecyclerView(){
        books_rv.layoutManager = LinearLayoutManager(this)
        books_rv.adapter = bookAdapter
    }
}