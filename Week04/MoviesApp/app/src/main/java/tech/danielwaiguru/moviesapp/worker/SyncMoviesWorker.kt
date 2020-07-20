package tech.danielwaiguru.moviesapp.worker

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import retrofit2.HttpException
import tech.danielwaiguru.moviesapp.MovieApp
import tech.danielwaiguru.moviesapp.database.MovieDatabase
import tech.danielwaiguru.moviesapp.models.Success

class SyncMoviesWorker(context: Context, workerParameters: WorkerParameters):
    CoroutineWorker(context, workerParameters) {
    companion object{
        const val WORK_NAME = "SyncMoviesWorker"
    }
    private val remoteApi by lazy { MovieApp.remoteApi }
    private val movieDao by lazy {
        MovieDatabase.getDatabaseInstance(applicationContext).movieDao()
    }
    override suspend fun doWork(): Result {
        try {
            refreshData()
        }
        catch (error: HttpException){
            return Result.retry()
        }
        return Result.success()
    }
    private suspend fun refreshData(){
        val result = remoteApi.getPopularMovies()
        if (result is Success){
            Log.d("WORKER", "Refreshing the data")
            movieDao.insertMovie(result.data)
        }
    }
}