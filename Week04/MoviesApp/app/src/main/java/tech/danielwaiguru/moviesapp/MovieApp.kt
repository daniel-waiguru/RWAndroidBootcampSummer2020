package tech.danielwaiguru.moviesapp

import android.app.Application
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import org.koin.android.ext.koin.androidContext
import org.koin.android.logger.AndroidLogger
import org.koin.core.context.startKoin
import tech.danielwaiguru.moviesapp.di.*
import tech.danielwaiguru.moviesapp.worker.SyncMoviesWorker
import java.util.concurrent.TimeUnit

class MovieApp: Application() {
    companion object{
        private lateinit var instance: MovieApp
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
        setRecurringWork()
        initKoin()
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
    //initialize koin
    private fun initKoin(){
        startKoin {
            AndroidLogger()
            androidContext(this@MovieApp)
            modules(listOf(networkMode, viewModelModule, repositoryModule, databaseModule, prefsModule))
        }
    }
}