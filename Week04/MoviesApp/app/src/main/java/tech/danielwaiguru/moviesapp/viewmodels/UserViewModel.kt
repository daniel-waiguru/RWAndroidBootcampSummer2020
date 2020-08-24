package tech.danielwaiguru.moviesapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import tech.danielwaiguru.moviesapp.models.User
import tech.danielwaiguru.moviesapp.repositories.UserRepository

class UserViewModel(private val userRepository: UserRepository): ViewModel() {
    fun registerUser(user: User) = viewModelScope.launch(Dispatchers.IO) {
        userRepository.registerUser(user)
    }
    fun isUserValid(username: String, password: String): Boolean {
        return userRepository.loginUser(username, password)
    }

}