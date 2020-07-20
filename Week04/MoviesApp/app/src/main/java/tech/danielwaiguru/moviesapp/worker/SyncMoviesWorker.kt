package tech.danielwaiguru.moviesapp.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import retrofit2.HttpException
import tech.danielwaiguru.moviesapp.MovieApp
import tech.danielwaiguru.moviesapp.database.MovieDatabase
import tech.danielwaiguru.moviesapp.models.Success

class SyncMoviesWorker(context: Context, workerParameters: WorkerParameters):
    CoroutineWorker(context, workerParameters) {
    override suspend fun doWork(): Result {
        val movieDao = MovieDatabase.getDatabaseInstance(applicationContext).movieDao()
        val remoteApi by lazy { MovieApp.remoteApi }
        val result = remoteApi.getPopularMovies()
        try {
            if (result is Success){
                movieDao.insertMovie(result.data)
            }
        }
        catch (error: HttpException){
            return Result.retry()
        }
        return Result.success()
    }
}