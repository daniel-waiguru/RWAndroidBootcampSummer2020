package tech.danielwaiguru.moviesapp.repositories

import tech.danielwaiguru.moviesapp.database.UserDao
import tech.danielwaiguru.moviesapp.models.User

class UserRepository(private val userDao: UserDao) {
    /**
     * Register user
     */
    suspend fun registerUser(user: User){
        userDao.registerUser(user)
    }
    fun loginUser(username: String, password: String): Boolean{
        val user: User? = userDao.loginUser(username)
        //return user?.password == password
        val pass = user?.password.toString()
        return when (password) {
            pass -> true
            else -> false
        }
    }

}