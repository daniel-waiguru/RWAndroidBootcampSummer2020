package tech.danielwaiguru.moviesapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import tech.danielwaiguru.moviesapp.models.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun registerUser(user: User): Long

    @Query("SELECT * FROM users WHERE username LIKE :username AND password LIKE :password")
    suspend fun loginUser( username: String, password: String): User?
}