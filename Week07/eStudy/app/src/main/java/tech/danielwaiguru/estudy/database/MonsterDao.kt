package tech.danielwaiguru.estudy.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import tech.danielwaiguru.estudy.models.Monster

@Dao
interface MonsterDao {
    @Insert
    suspend fun insertMonster(monster: List<Monster>)
    @Query("SELECT * FROM monsters")
    fun getAllMonsters(): LiveData<List<Monster>>
}