package tech.danielwaiguru.moviesapp

import android.app.Application
import androidx.room.Room
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import org.koin.android.ext.koin.androidContext
import org.koin.android.logger.AndroidLogger
import org.koin.core.context.startKoin
import tech.danielwaiguru.moviesapp.database.MovieDatabase
import tech.danielwaiguru.moviesapp.di.coroutineModule
import tech.danielwaiguru.moviesapp.di.networkMode
import tech.danielwaiguru.moviesapp.networking.RemoteApi
import tech.danielwaiguru.moviesapp.networking.buildMovieApiService
import tech.danielwaiguru.moviesapp.repositories.MovieRepository
import tech.danielwaiguru.moviesapp.repositories.UserRepository
import tech.danielwaiguru.moviesapp.viewmodels.UserViewModelFactory
import tech.danielwaiguru.moviesapp.worker.SyncMoviesWorker
import java.util.concurrent.TimeUnit

class MovieApp: Application() {
    companion object{
        private lateinit var instance: MovieApp
        private val movieDatabase: MovieDatabase by lazy {
            Room.databaseBuilder(instance, MovieDatabase::class.java, "movies").build()
        }
        private val moviesApiService by lazy { buildMovieApiService() }
        val movieRepository: MovieRepository by lazy { MovieRepository(movieDao, remoteApi) }
        val remoteApi by lazy { RemoteApi(moviesApiService) }
        val movieDao by lazy { movieDatabase.movieDao() }
        private val userDao by lazy { movieDatabase.userDao() }
        private val userRepository by lazy { UserRepository(userDao) }
        val userViewModelFactory by lazy { UserViewModelFactory(userRepository) }
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
            modules(listOf(networkMode, coroutineModule))
        }
    }
}