package tech.danielwaiguru.estudy.repositories

import android.content.Context
import tech.danielwaiguru.estudy.preferences.SharedPrefsManager

class UserPrefsRepository(context: Context) {
    private val sharedPrefsManager by lazy {
        SharedPrefsManager(context)
    }
    fun isUserLoggedIn(isLoggedIn: Boolean) = sharedPrefsManager.isUserLoggedIn(isLoggedIn)
    fun userStatus() = sharedPrefsManager.getUserStatus()
}