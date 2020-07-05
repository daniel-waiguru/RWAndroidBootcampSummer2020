package tech.danielwaiguru.moviesapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import tech.danielwaiguru.moviesapp.models.User

@Dao

interface UserDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun registerUser(user: User)
    @Query("SELECT * FROM users WHERE username LIKE :username")
    fun loginUser( username: String): User
}