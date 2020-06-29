package tech.danielwaiguru.moviesapp.repositories

import android.content.Context
import tech.danielwaiguru.moviesapp.data.User

class UserPrefRepository(context: Context) {
    companion object{
        private const val USER = "USER"
    }
    private val appContext: Context = context.applicationContext
    private val sharedPrefs = appContext.getSharedPreferences(USER, Context.MODE_PRIVATE)
    fun saveUser(user:User){
        sharedPrefs.edit().putBoolean(user.id, user.isLoggedin).apply()
    }
}