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
}