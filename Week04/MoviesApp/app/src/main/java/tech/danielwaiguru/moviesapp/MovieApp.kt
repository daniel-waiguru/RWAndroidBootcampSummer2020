package tech.danielwaiguru.moviesapp

import android.app.Application
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import tech.danielwaiguru.moviesapp.networking.RemoteApi
import tech.danielwaiguru.moviesapp.networking.buildMovieApiService
import tech.danielwaiguru.moviesapp.worker.SyncMoviesWorker
import java.util.concurrent.TimeUnit

class MovieApp: Application() {
    private val applicationScope = CoroutineScope(Dispatchers.Default)
    companion object{
        private lateinit var instance: MovieApp
        private val moviesApiService by lazy { buildMovieApiService() }
        val remoteApi by lazy { RemoteApi(moviesApiService) }
    }


    override fun onCreate() {
        super.onCreate()
        instance = this
        delayedInit()
    }

    /**
     * Setting recurring work to refresh movies data every one hour
     */
    private fun setRecurringWork(){
        val constraints = androidx.work.Constraints.Builder()
            .setRequiresBatteryNotLow(true)
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        val syncMoviesWorker =
            PeriodicWorkRequestBuilder<SyncMoviesWorker>(20, TimeUnit.MINUTES)
                .setConstraints(constraints)
                .build()
        val workManager = WorkManager.getInstance(this)
        workManager.enqueueUniquePeriodicWork(
            SyncMoviesWorker.WORK_NAME,
            ExistingPeriodicWorkPolicy.KEEP,
            syncMoviesWorker
        )
    }
    /**
     * method to start a coroutine
     */
    private fun delayedInit(){
        applicationScope.launch {
            setRecurringWork()
        }
    }
}