package tech.danielwaiguru.moviesapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MovieDao {
    /**
     * storing movies data
     */
    @Insert
    suspend fun insert(movie: List<Movie>)
    /**
     * retrieving all movies
     */
    @Query("SELECT * FROM movie")
    fun getAllMovies(): LiveData<List<Movie>>
}