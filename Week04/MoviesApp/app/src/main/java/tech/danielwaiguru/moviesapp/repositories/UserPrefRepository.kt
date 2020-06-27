package tech.danielwaiguru.moviesapp.repositories

import android.content.Context

class UserPrefRepository(context: Context) {
    companion object{
        private const val NAME = "NAME"
        private const val USERNAME = "USERNAME"
        private const val PASSWORD = "PASSWORD"
        private const val USER = "USER"
    }
    private val appContext: Context = context.applicationContext
    private val sharedPrefs = appContext.getSharedPreferences(USER, Context.MODE_PRIVATE)
    fun saveUser(name: String, username: String, password: String){
        sharedPrefs.edit().apply {
            this.putString(NAME, name)
            this.putString(USERNAME, username)
            this.putString(PASSWORD, password)
        }.apply()

    }
    fun getUser(){
        val username = sharedPrefs.getString(USERNAME, "")
        val password = sharedPrefs.getString(PASSWORD, "")

    }
}