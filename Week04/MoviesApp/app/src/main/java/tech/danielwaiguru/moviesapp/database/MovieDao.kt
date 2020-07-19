package tech.danielwaiguru.moviesapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MovieDao {
    /**
     * storing movies data
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movie: List<Movie>)
    /**
     * retrieving all movies
     */
    @Query("SELECT * FROM movie")
    fun getAllMovies(): List<Movie>
    /**
     * Deleting all movies
     */
    @Query("DELETE FROM movie")
    suspend fun deleteAllMovies()
}