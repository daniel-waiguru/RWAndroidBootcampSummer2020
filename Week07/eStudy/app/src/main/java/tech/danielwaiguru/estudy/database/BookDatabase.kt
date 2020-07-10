package tech.danielwaiguru.estudy.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class BookDatabase(context: Context): RoomDatabase() {
    abstract fun bookDao(): BookDao

    /**
     * Singleton database instance
     */
    companion object{
        @Volatile
        private var INSTANCE: BookDatabase? = null

        fun getDatabaseInstance(context: Context): BookDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BookDatabase::class.java,
                    "books.db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}