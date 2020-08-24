package tech.danielwaiguru.estudy.preferences

import android.content.Context

class SharedPrefsManager(context: Context) {
    companion object{
        const val USER = "USER"
    }
    private val sharedPrefs = context.getSharedPreferences(USER, Context.MODE_PRIVATE)
    fun isUserLoggedIn(isLoggedIn: Boolean){
        sharedPrefs.edit().putBoolean(USER, isLoggedIn).apply()
    }
    fun getUserStatus() = sharedPrefs.getBoolean(USER, false)
}