package tech.danielwaiguru.estudy.networking

import retrofit2.Response
import retrofit2.http.GET
import tech.danielwaiguru.estudy.models.Monster


interface MonsterApiService {
    @GET("/feed/monster_data.json")
    suspend fun getMonsters(): Response<List<Monster>>
}