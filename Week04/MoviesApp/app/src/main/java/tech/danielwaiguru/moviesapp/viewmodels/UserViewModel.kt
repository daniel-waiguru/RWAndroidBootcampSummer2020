package tech.danielwaiguru.moviesapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import tech.danielwaiguru.moviesapp.database.MovieDatabase
import tech.danielwaiguru.moviesapp.models.User

import tech.danielwaiguru.moviesapp.repositories.UserRepository

class UserViewModel(application: Application): AndroidViewModel(application) {
    private val userRepository: UserRepository
    init {
        val userDao = MovieDatabase.getDatabaseInstance(application).userDao()
        userRepository = UserRepository(userDao)
    }
    fun registerUser(user: User) = viewModelScope.launch(Dispatchers.IO) {
        userRepository.registerUser(user)
    }
    fun isUserValid(username: String, password: String): Boolean {
        return userRepository.loginUser(username, password)
    }

}