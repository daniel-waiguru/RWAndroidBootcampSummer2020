package tech.danielwaiguru.estudy.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import tech.danielwaiguru.estudy.networking.IMAGES_URL

@Entity(tableName = "monsters")
data class Monster(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val imageFile: String,
    val monsterName: String,
    val caption: String,
    val description: String,
    val price: Double,
    val scariness: Int
){
    val thumbNail
    get() = "$IMAGES_URL/${imageFile}_tn.webp"
}