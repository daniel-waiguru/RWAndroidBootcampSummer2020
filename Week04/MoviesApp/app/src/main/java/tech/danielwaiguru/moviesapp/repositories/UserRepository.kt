package tech.danielwaiguru.moviesapp.repositories

import org.koin.core.KoinComponent
import org.koin.core.inject
import tech.danielwaiguru.moviesapp.database.UserDao
import tech.danielwaiguru.moviesapp.models.User

open class UserRepository: KoinComponent {
    private val userDao: UserDao by inject()
    /**
     * Register user
     */
    suspend fun registerUser(user: User){
        userDao.registerUser(user)
    }
    fun loginUser(username: String, password: String): Boolean{
        val user: User? = userDao.loginUser(username)
        val pass = user?.password.toString()
        return password == pass
    }

}