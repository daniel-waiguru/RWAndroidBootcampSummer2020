package tech.danielwaiguru.moviesapp.database

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
    suspend fun insertMovie(movie: List<Movie>)
    /**
     * retrieving all movies
     */
    @Query("SELECT * FROM movie")
    suspend fun getAllMovies(): List<Movie>
    /**
     * Deleting all movies
     */
    @Query("DELETE FROM movie")
    suspend fun deleteAllMovies()
}