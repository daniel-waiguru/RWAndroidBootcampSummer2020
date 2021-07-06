package tech.danielwaiguru.moviesapp.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject
import tech.danielwaiguru.moviesapp.database.UserDao
import tech.danielwaiguru.moviesapp.models.User

open class UserRepository: KoinComponent {
    private val userDao: UserDao by inject()
    /**
     * Register user
     */
    suspend fun registerUser(user: User): Flow<Long> = withContext(Dispatchers.IO) {
        flow {
            emit(userDao.registerUser(user))
        }
    }
    suspend fun loginUser(username: String, password: String): Flow<User?> = withContext(Dispatchers.IO) {
        flow {
            emit(userDao.loginUser(username, password))
        }
    }

}