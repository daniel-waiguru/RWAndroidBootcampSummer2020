package tech.danielwaiguru.estudy.database.converters

import androidx.room.TypeConverter
import tech.danielwaiguru.estudy.models.Authors

class Converters {
    @TypeConverter
    fun listToString(value: ByteArray): String{
        return String(value)
    }
}