package tech.danielwaiguru.estudy

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import tech.danielwaiguru.estudy.adapters.MonsterAdapter
import tech.danielwaiguru.estudy.repositories.UserPrefsRepository
import tech.danielwaiguru.estudy.ui.login.LoginActivity
import tech.danielwaiguru.estudy.viewmodels.MonsterViewModel

class MainActivity : AppCompatActivity() {
    private val monsterViewModel by lazy {
        ViewModelProvider(this).get(MonsterViewModel::class.java)
    }
    private val userPrefsRepository by lazy {
        UserPrefsRepository(applicationContext)
    }
    private val monsterAdapter by lazy {
        MonsterAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        swipe_layout.setOnRefreshListener {
            monsterViewModel.refreshData()
        }
        monsterViewModel.allMonsters.observe(this, Observer { monstersList ->
            monstersList?.let {
                monster_rv.layoutManager = GridLayoutManager(this, 2)
                monster_rv.adapter = monsterAdapter
                monsterAdapter.setData(it)
                swipe_layout.isRefreshing = false
            }
        })
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_about ->{
                true
            }
            R.id.action_logout ->{
                logoutUser()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun logoutUser() {
        userPrefsRepository.isUserLoggedIn(false)
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}