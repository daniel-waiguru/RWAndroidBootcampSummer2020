package tech.danielwaiguru.estudy.networking

import tech.danielwaiguru.estudy.models.Monster

class RemoteApi {
    suspend fun getMonsters(): Result<List<Monster>> =
        try {
            val data = buildServiceApi().getMonsters().body()!!
            Success(data)
        }
        catch (error: Throwable){
            Failure(error)
        }
}
