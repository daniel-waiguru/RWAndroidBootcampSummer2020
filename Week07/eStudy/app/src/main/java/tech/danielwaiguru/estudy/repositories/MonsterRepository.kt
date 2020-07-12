package tech.danielwaiguru.estudy.repositories

import android.app.Application
import android.net.ConnectivityManager
import android.util.Log
import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import tech.danielwaiguru.estudy.models.Monster
import tech.danielwaiguru.estudy.networking.NetworkStatusChecker
import tech.danielwaiguru.estudy.networking.RemoteApi
import tech.danielwaiguru.estudy.networking.Success

class MonsterRepository(app: Application) {
    private val networkStatusChecker by lazy {
        NetworkStatusChecker(app.getSystemService(ConnectivityManager::class.java))
    }
    private val remoteApi = RemoteApi()
    val monsters = MutableLiveData<List<Monster>>()
    init {
        refreshData()
    }
    @WorkerThread
    suspend fun getData(){
        networkStatusChecker.performIfConnectedToInternet {
            val result = remoteApi.getMonsters()
            if (result is Success){
                monsters.postValue(result.data)
            }
            else{
                Log.d("REPO", "Error from the server")
            }
        }
    }

    fun refreshData() {
        CoroutineScope(Dispatchers.IO).launch {
            getData()
        }
    }
}