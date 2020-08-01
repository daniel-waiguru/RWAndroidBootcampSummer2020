package tech.danielwaiguru.moviesapp.worker

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import org.koin.core.KoinComponent
import org.koin.core.inject
import retrofit2.HttpException
import tech.danielwaiguru.moviesapp.database.MovieDao
import tech.danielwaiguru.moviesapp.models.Success
import tech.danielwaiguru.moviesapp.networking.RemoteApi

class SyncMoviesWorker(context: Context, workerParameters: WorkerParameters):
    CoroutineWorker(context, workerParameters), KoinComponent {
    companion object{
        const val WORK_NAME = "SyncMoviesWorker"
    }
    private val remoteApi by inject<RemoteApi>()
    private val movieDao:MovieDao by inject()
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
        val result = remoteApi.getPopularMovies(1)
        if (result is Success){
            Log.d("WORKER", "Refreshing the data")
            movieDao.insertMovie(result.data)
        }
    }
}