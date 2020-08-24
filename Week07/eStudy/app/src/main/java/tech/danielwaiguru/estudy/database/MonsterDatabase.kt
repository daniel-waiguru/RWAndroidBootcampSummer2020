package tech.danielwaiguru.estudy.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import tech.danielwaiguru.estudy.models.Monster

@Database(entities = [Monster::class], version = 1, exportSchema = false)
abstract class MonsterDatabase: RoomDatabase() {
    abstract fun monsterDao(): MonsterDao

    /**
     * Singleton database instance
     */
    companion object{
        @Volatile
        private var INSTANCE: MonsterDatabase? = null

        fun getDatabaseInstance(context: Context): MonsterDatabase{
            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MonsterDatabase::class.java,
                        "monsters.db"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}