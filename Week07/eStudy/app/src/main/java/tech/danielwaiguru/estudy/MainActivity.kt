package tech.danielwaiguru.estudy

import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import tech.danielwaiguru.estudy.adapters.BookAdapter
import tech.danielwaiguru.estudy.models.Book
import tech.danielwaiguru.estudy.networking.NetworkStatusChecker
import tech.danielwaiguru.estudy.networking.RemoteApi
import tech.danielwaiguru.estudy.networking.Success
import tech.danielwaiguru.estudy.repositories.UserPrefsRepository
import tech.danielwaiguru.estudy.ui.login.LoginActivity
import tech.danielwaiguru.estudy.viewmodels.BookViewModel

class MainActivity : AppCompatActivity() {
    private val TAG = javaClass.simpleName
    private val bookAdapter by lazy {
        BookAdapter()
    }
    private val remoteApi = RemoteApi()
    private val bookViewModel by lazy {
        ViewModelProvider(this).get(BookViewModel::class.java)
    }
    private val userPrefsRepository by lazy {
        UserPrefsRepository(applicationContext)
    }
    private val networkStatusChecker by lazy {
        NetworkStatusChecker(getSystemService(ConnectivityManager::class.java))
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
        networkStatusChecker.performIfConnectedToInternet {
            GlobalScope.launch {
                val result = remoteApi.getBooks()
                if (result is Success){
                    onBooksListReceived(result.data)
                    Log.d("BOOK", "${result.data}")
                }
                else{
                    onGetBooksFailed()
                }
            }
        }
    }

    private fun onGetBooksFailed() {

        Log.d(TAG, "Failed to get books")
    }

    private fun onBooksListReceived(data: List<Book>) {
        onBooksReceived(data)
    }

    private fun onBooksReceived(data: List<Book>) = bookViewModel.insert(data)
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_about ->{
                true
            }
            R.id.action_logout ->{
                logoutUser()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun logoutUser() {
        userPrefsRepository.isUserLoggedIn(false)
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}