package tech.danielwaiguru.estudy.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import tech.danielwaiguru.estudy.database.MonsterDatabase
import tech.danielwaiguru.estudy.models.Monster
import tech.danielwaiguru.estudy.repositories.MonsterRepository

class MonsterViewModel(application: Application): AndroidViewModel(application) {
    private val monsterRepository: MonsterRepository

    init {
        val monsterDao = MonsterDatabase.getDatabaseInstance(application).monsterDao()
        monsterRepository = MonsterRepository(application)
    }
    val allMonsters = monsterRepository.monsters
    fun refreshData() {
        monsterRepository.refreshData()
    }
}