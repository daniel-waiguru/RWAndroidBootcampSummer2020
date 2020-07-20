package tech.danielwaiguru.moviesapp.repositories

import android.app.Application
import android.net.ConnectivityManager
import android.util.Log
import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import tech.danielwaiguru.moviesapp.MovieApp
import tech.danielwaiguru.moviesapp.database.Movie
import tech.danielwaiguru.moviesapp.database.MovieDatabase
import tech.danielwaiguru.moviesapp.models.Success
import tech.danielwaiguru.moviesapp.networking.NetworkStatusChecker

class MovieRepository(app: Application) {
    val allMovies = MutableLiveData<List<Movie>>()
    private val networkStatusChecker by lazy {
        NetworkStatusChecker(app.getSystemService(ConnectivityManager::class.java)!!)
    }
    private val remoteApi by lazy { MovieApp.remoteApi }
    private val movieDao = MovieDatabase.getDatabaseInstance(app).movieDao()
    init {
        CoroutineScope(Dispatchers.IO).launch {
            fetchData()
            val data = movieDao.getAllMovies()
            allMovies.postValue(data)
        }
    }

    @WorkerThread
    private suspend fun fetchData(){
        networkStatusChecker.performIfConnectedToInternet {
            val result = remoteApi.getPopularMovies()
            if (result is Success){
                movieDao.insertMovie(result.data)
            }
            else{
                Log.d("API", "Server Error")
            }

        }
    }
}