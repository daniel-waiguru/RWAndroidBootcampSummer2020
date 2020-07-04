package tech.danielwaiguru.moviesapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import tech.danielwaiguru.moviesapp.database.MovieDatabase
import tech.danielwaiguru.moviesapp.models.User
import tech.danielwaiguru.moviesapp.repositories.UserRepository

class UserViewModel(application: Application): AndroidViewModel(application) {
    private val userPrefRepository: UserRepository
    init {
        val userDao = MovieDatabase.getDatabaseInstance(application, viewModelScope).userDao()
        userPrefRepository = UserRepository(userDao)
    }
    fun registerUser(user: User) = viewModelScope.launch {
        userPrefRepository.registerUser(user)
    }
}