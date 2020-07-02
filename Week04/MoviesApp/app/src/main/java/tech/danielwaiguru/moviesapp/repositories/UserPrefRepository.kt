package tech.danielwaiguru.moviesapp.repositories

import android.content.Context
import tech.danielwaiguru.moviesapp.prefs.PrefManager

class UserPrefRepository(context: Context) {
    private val prefManager = PrefManager(context)
    fun saveUser(isLoggedIn: Boolean) = prefManager.saveUser(isLoggedIn)
    fun isUserLoggedIn() = prefManager.isUserLoggedIn()
}