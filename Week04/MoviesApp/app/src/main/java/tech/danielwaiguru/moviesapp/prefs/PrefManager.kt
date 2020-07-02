package tech.danielwaiguru.moviesapp.prefs

import android.content.Context

class PrefManager(context: Context) {
    companion object{
        const val USER = ""
    }
    private val appContext: Context = context.applicationContext
    private val sharedPrefs = appContext.getSharedPreferences(USER, Context.MODE_PRIVATE)
    fun saveUser(isLoggedIn: Boolean){
        sharedPrefs.edit().putBoolean(USER, isLoggedIn).apply()
    }
    fun isUserLoggedIn() = sharedPrefs.getBoolean(USER, false)
}