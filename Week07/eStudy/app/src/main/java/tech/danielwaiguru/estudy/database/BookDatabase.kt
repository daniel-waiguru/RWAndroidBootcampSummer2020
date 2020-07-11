package tech.danielwaiguru.estudy.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import tech.danielwaiguru.estudy.models.Book

@Database(entities = [Book::class], version = 1, exportSchema = false)
abstract class BookDatabase: RoomDatabase() {
    abstract fun bookDao(): BookDao

    /**
     * Singleton database instance
     */
    companion object{
        @Volatile
        private var INSTANCE: BookDatabase? = null

        fun getDatabaseInstance(context: Context): BookDatabase{
            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BookDatabase::class.java,
                        "books.db"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}