package tech.danielwaiguru.moviesapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject
import tech.danielwaiguru.moviesapp.models.User
import tech.danielwaiguru.moviesapp.repositories.UserRepository

class UserViewModel: ViewModel(), KoinComponent {
    private val userRepository: UserRepository by inject()
    fun registerUser(user: User) = viewModelScope.launch(Dispatchers.IO) {
        userRepository.registerUser(user)
    }
    fun isUserValid(username: String, password: String): Boolean {
        return userRepository.loginUser(username, password)
    }

}