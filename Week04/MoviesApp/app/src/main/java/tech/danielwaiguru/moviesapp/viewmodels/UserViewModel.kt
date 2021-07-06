package tech.danielwaiguru.moviesapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject
import tech.danielwaiguru.moviesapp.models.User
import tech.danielwaiguru.moviesapp.repositories.UserRepository
import tech.danielwaiguru.moviesapp.utils.Resource

class UserViewModel: ViewModel(), KoinComponent {
    private val userRepository: UserRepository by inject()
    private val _registerStatus: MutableLiveData<Resource<Long>> = MutableLiveData()
    val registerStatus: LiveData<Resource<Long>> get() = _registerStatus
    private val _userStatus: MutableLiveData<Resource<User?>> = MutableLiveData()
    val userStatus: LiveData<Resource<User?>> get() = _userStatus
    fun registerUser(user: User) {
        viewModelScope.launch {
            userRepository.registerUser(user)
                .onStart {
                    _registerStatus.value = Resource.loading(null)
                }.catch {
                    _registerStatus.value = Resource.error("Registration failed", null)
                }
                .collect {
                    _registerStatus.value = Resource.success(it)
                }
        }
    }
    fun loginUser(username: String, password: String) = viewModelScope.launch {
        userRepository.loginUser(username, password)
            .onStart {
                _userStatus.value = Resource.loading(null)
            }
            .catch {
                _userStatus.value = Resource.error("Login failed", null)
            }
            .collect {
                _userStatus.value = Resource.success(it)
            }
    }

}