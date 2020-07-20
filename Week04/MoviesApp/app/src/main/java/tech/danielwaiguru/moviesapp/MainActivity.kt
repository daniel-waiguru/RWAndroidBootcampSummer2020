package tech.danielwaiguru.moviesapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import tech.danielwaiguru.moviesapp.repositories.UserPrefRepository
import tech.danielwaiguru.moviesapp.ui.login.LoginFragment

class MainActivity : AppCompatActivity() {
    private val userPrefRepository by lazy {
        UserPrefRepository(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_about ->{
                aboutEmpireMovieApp()
                true
            }
            R.id.action_share ->{
                shareAction()
                true
            }
            R.id.action_settings ->{
                true
            }
            R.id.action_logout ->{
                logout()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    /**
     * function open sharing dialog
     */
    private fun shareAction(){
        val shareIntent = Intent()
        shareIntent.type = "text/plain"
        Intent.createChooser(shareIntent, "Share Via")
        startActivity(shareIntent)
    }
    /**
     * About dialog
     */
    private fun aboutEmpireMovieApp(){
        val appName = getString(R.string.name)
        val aboutMessage = getString(R.string.aboutText)
        val positiveButtonText = getString(R.string.ok_button)
        val aboutDialog = AlertDialog.Builder(this)
        aboutDialog.setTitle(appName)
        aboutDialog.setMessage(aboutMessage)
        aboutDialog.setPositiveButton(positiveButtonText){_, _ ->

        }
        aboutDialog.create().show()

    }
    /**
     * method to logout users
     */
    private fun logout(){
        userPrefRepository.saveUser(false)
        val loginFragment = LoginFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, loginFragment)
            .commit()
    }
}